package com.callin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callin.domain.UserDto;
import com.callin.service.UserService;

@Controller
public class AdminController {

	private final UserService userService;
	
	@Autowired
	public AdminController(UserService userService) {
		this.userService = userService;
	}
	
	
	//회원 전체 조회
	@GetMapping("/userList")
	public String userList(Model model) {

		List<UserDto> userList = userService.getUserList();
		
		model.addAttribute("title", "회원조회");
		model.addAttribute("userList", userList);
		return "adminPage/userList";
	}
	
	//회원 전체 조회
	@GetMapping(value="/userList11", produces = "application/json")
	@ResponseBody
	public UserDto userList11(Model model, @RequestParam("userId") String userId) {
		UserDto userDto = userService.getUserRead(userId);
		if(userDto == null) userDto = new UserDto();
		return userDto;
	}
	
	
}
