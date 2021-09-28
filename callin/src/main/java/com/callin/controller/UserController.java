package com.callin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	//로그인
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title","로그인화면");
		return "userPage/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam(name="id", required = false)String id,
						@RequestParam(name="password", required = false)String password) {
		System.out.println(id + "<<<<<<<<id");					
		System.out.println(password + "<<<<<<<<<<<<password");					
		
		return "main";
	}
	
	//회원가입
	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("title", "회원가입");
		return "userPage/join";
	}
	@PostMapping("/join")
	public String join(@RequestParam(name="inpugName", required = false)String name,
						@RequestParam(name="inputId", required = false)String id,
						@RequestParam(name="inputPw", required = false)String pw,
						@RequestParam(name="inputEmail", required = false)String email,
						@RequestParam(name="inputPhoneNum", required = false)String phoneNum,
						@RequestParam(name="inputNick", required = false)String nick) {
		System.out.println(name + "<<<<<<<<name");					
		System.out.println(id + "<<<<<<<<<<<<id");					
		System.out.println(pw + "<<<<<<<<<<<<pw");					
		System.out.println(email + "<<<<<<<<<<<<email");					
		System.out.println(phoneNum + "<<<<<<<<<<<<phoneNum");					
		System.out.println(nick + "<<<<<<<<<<<<nick");					
		
		return "userPage/login";
	}
	
	//아이디, 비밀번호 찾기
	@GetMapping("/idFind")
	public String idFind(Model model) {
		model.addAttribute("title", "아이디 찾기");
		return "userPage/idFind";
	}
	
	@PostMapping("/idFind")
	public String idFind(@RequestParam(name="inputName", required = false)String name,
						 @RequestParam(name="inputEmail", required = false)String email) {
		System.out.println(name + "<<<<<<<<<<name");
		System.out.println(email + "<<<<<<<<<<email");
		return "userPage/login";
	}
	
	@GetMapping("/pwFind")
	public String pwFind(Model model) {
		model.addAttribute("title", "비밀번호 찾기");
		return "userPage/pwFind";
	}
	
	
	//나의 수업
	@GetMapping("/myLesson")
	public String myLesson(Model model) {
		model.addAttribute("title", "나의 수업");
		return "userPage/myLesson";
	}
	
	//나의 정보
	@GetMapping("/myInfo")
	public String myInfo(Model model) {
		model.addAttribute("title", "회원정보");
		return "userPage/myInfo";
	}
	
	
	//수강신청
	@GetMapping("/lessonApply")
	public String lessonApply(Model model) {
		model.addAttribute("title", "수강신청");
		return "userPage/lessonApply";
	}
	
	//결제
	@GetMapping("/payment")
	public String payment(Model model) {
		model.addAttribute("title", "결제");
		return "userPage/payment";
	}
	
	//결제및수강내역
	@GetMapping("/lessonDetail")
	public String lessonDetail(Model model) {
		model.addAttribute("title", "수강/결제내역");
		return "userPage/lessonDetail";
	}
	
	//이벤트
	@GetMapping("/event")
	public String event(Model model) {
		model.addAttribute("title", "이벤트");
		return "userPage/event";
	}
	
	//환불
	@GetMapping("/counsel")
	public String counsel(Model model) {
		model.addAttribute("title", "Q&A");
		return "userPage/counsel";
	}
	
	
	
}
