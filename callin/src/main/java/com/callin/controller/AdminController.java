package com.callin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callin.domain.ClassProgressDto;
import com.callin.domain.UserDto;
import com.callin.service.AdminService;
import com.callin.service.UserService;

@Controller
public class AdminController {

	//의존성 주입
	private final UserService userService;
	private final AdminService adminService;
	
	@Autowired
	public AdminController(UserService userService, AdminService adminService) {
		this.userService = userService;
		this.adminService = adminService;
	}
	
	
	//회원 전체 조회
	@GetMapping("/userList")
	public String userList(Model model) {

		List<UserDto> userList = adminService.getUserList();
		
		model.addAttribute("title", "회원조회");
		model.addAttribute("userList", userList);
		return "adminPage/userList";
	}
	
	
	//회원 전체 조회에서 진행중인 수업확인하는 Ajax
	@GetMapping(value="/userIdClick", produces = "application/json")
	@ResponseBody
	public ClassProgressDto userIdClick(Model model, @RequestParam("userId") String userId) {
		
		System.out.println("화면에서 선택한 학생ID (AdminController.java) : " + userId);
		
		ClassProgressDto classDto = adminService.getUserClass(userId);
		
		if(classDto != null) {
			System.out.println("한명 학생의 수업 정보 조회 결과 (AdminController.java) : " + classDto.toString());
		}
		
		
		return classDto;
	}
	
	
}






























