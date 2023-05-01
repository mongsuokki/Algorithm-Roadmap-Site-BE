package com.Seoul5.Algo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Seoul5.Algo.model.dto.User;
import com.Seoul5.Algo.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {

	@Autowired
	UserService us;
	
	@GetMapping("/user")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		List<User> list = us.selectAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	@ApiOperation(value = "새로운 사용자 정보를 등록한다.", response = Integer.class)
	public ResponseEntity<?> insert(User user) {
		// img 등록
		// 아이디 중복검사
		// 비밀번호 양식 유효성 검사
		int res = us.insert(user);
		return new ResponseEntity<Integer>(res, HttpStatus.OK);
	}	
	
	@PutMapping("/user")
	@ApiOperation(value = "유저 정보를 수정한다.")
	public ResponseEntity<?> update(User user){
		us.update(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "ID로 유저를 검색한다.", response = User.class)
	public ResponseEntity<?> searchById(@PathVariable String id){
		List<User> list = us.searchById(id);
		if(list != null&&list.size()>0) {
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/user/login")
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
	
	@GetMapping("/user/logout")
	@ApiOperation(value = "로그아웃을 진행한다.")
	public ResponseEntity<Void> logout(HttpSession session){
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
