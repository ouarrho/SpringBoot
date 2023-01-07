package com.hello.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.dto.UserDto;
import com.hello.requests.UserRequest;
import com.hello.responses.UserResponse;
import com.hello.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping
	public UserResponse post(@RequestBody UserRequest userRequest) {
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDto createUser = userService.createUser(userDto);
		
		UserResponse userResponse = new UserResponse();
		
		BeanUtils.copyProperties(createUser, userResponse);

		return userResponse;

	}

	@GetMapping
	public String get() {
		
		return "get";
		
	}

	@PutMapping
	public String put() {
		
		return "put";
		
	}

	@DeleteMapping
	public String delete() {
		
		return "delete";
		
	}

}
