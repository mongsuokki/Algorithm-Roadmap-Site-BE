package com.Seoul5.Algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("user")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		
		List<User> users = us.selectAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping("user")
	@ApiOperation(value = "새로운 사용자 정보를 등록한다.", response = Integer.class)
	public ResponseEntity<?> insert(User user) {
		
		int res = us.insert(user);
		return new ResponseEntity<Integer>(res, HttpStatus.OK);
	}	
}
