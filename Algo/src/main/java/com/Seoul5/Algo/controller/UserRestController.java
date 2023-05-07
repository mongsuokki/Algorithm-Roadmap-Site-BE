package com.Seoul5.Algo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Seoul5.Algo.model.dto.User;
import com.Seoul5.Algo.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {

	// 더 추가해야할 것
	// 백준Api와 연동해서 주단위로 solvedCnt 업데이트
	
	@Autowired
	UserService us;
	
	@Autowired
	ResourceLoader resLoader;
	
	@GetMapping("/list")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		List<User> list = us.selectAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	@ApiOperation(value = "새로운 사용자 정보를 등록한다.", response = Integer.class)
	public ResponseEntity<?> insert(@ModelAttribute User user, @RequestPart(required = false) MultipartFile file, Model model)throws IllegalStateException, IOException {
		if (file != null && file.getSize() > 0) {
			// 이미지 등록하기
			Resource res = resLoader.getResource("resources/upload");
			user.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			user.setOrgImg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + user.getImg()));
		}
		// 아이디 중복 검사
		if(us.searchById(user.getId())==null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		// 비밀번호 양식 유효성 검사
		String passwordpattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";
		// 8-16자, 최소 1개의 알파벳, 1개의 숫자, 1개의 특수문자
		// 이메일 양식 유효성 검사
		String emailpattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		if(!Pattern.matches(passwordpattern, user.getPassword())||!Pattern.matches(emailpattern, user.getEmail())) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		int res = us.insert(user);
		return new ResponseEntity<Integer>(res, HttpStatus.OK);
	}	
	
	@PutMapping("/update")
	@ApiOperation(value = "유저 정보를 수정한다.")
	public ResponseEntity<?> update(User user){
		us.update(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{id}")
	@ApiOperation(value = "ID로 유저를 검색한다.", response = User.class)
	public ResponseEntity<?> searchById(@PathVariable String id){
		List<User> list = us.searchById(id);
		if(list != null&&list.size()>0) {
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "로그인을 진행한다.")
	public ResponseEntity<Void> login(User user, HttpSession session){
		User loginUser = us.selectById(user.getId());
		if(loginUser !=null && user.getPassword().equals(loginUser.getPassword())) {
			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/logout")
	@ApiOperation(value = "로그아웃을 진행한다.")
	public ResponseEntity<Void> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}
