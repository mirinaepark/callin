package com.callin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.callin.domain.UserDto;
import com.callin.service.AdminService;
import com.callin.service.UserService;

@Controller
public class UserController {
	
	//의존성 주입
	private final UserService userService;
	private final AdminService adminService;
	
	@Autowired
	public UserController(UserService userService, AdminService adminService) {
		this.userService = userService;
		this.adminService = adminService;
	}
	
	//로그인
	@GetMapping("/login")
	public String login(Model model
						,@RequestParam(name="result", required = false)String result) {
		model.addAttribute("title","로그인화면");
		if(result != null) model.addAttribute("result", result);
		return "userPage/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="loginId", required = false)String loginId
						,@RequestParam(name="loginPw", required = false)String loginPw
						,HttpSession session
						,RedirectAttributes redirectAttr) {
		System.out.println(loginId + "<<<<<<<<id");					
		System.out.println(loginPw + "<<<<<<<<<<<<password");					
		
		//1.회원이 있는 경우
		if(loginId != null && !"".equals(loginId) &&
		   loginPw != null && !"".equals(loginPw)) {
		   UserDto userDto = userService.getUserRead(loginId);
		   if(userDto != null) {
			   if(loginPw.equals(userDto.getUserPw())) {
				   session.setAttribute("SID", loginId);
				   session.setAttribute("SLEVEL", userDto.getUserName());
				   session.setAttribute("SNAME", userDto.getUserLevel());
				   return "redirect:/";
			   }
		   }
		}
		//2. 회원이 없다면 redirect:/login result => 등록된 정보가 없습니다.
		redirectAttr.addAttribute("result", "등록된 정보가 없습니다.");
		return "redirect:/login";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
		
	}
	//회원가입
	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("title", "회원가입");
		return "userPage/join";
	}
	@PostMapping("/join")
	public String join(@RequestParam(name="inputName", required = false)String name,
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
	
	// 아이디 중복 체크하는 Ajax
	@RequestMapping(value="/joinIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public boolean joinIdCheck(@RequestParam(name="userIdCheck", required = false)String userIdCheck) {
		//중복 아이디 체크를 위한 boolean타입 변수 선언
		//중복된 아이디가 있는경우 false로 변경한다.
		boolean joinIdCheck = true;
		
		
		System.out.println("화면에서 입력한 아이디 (UserController.java) : " + userIdCheck);
		
		//한명 회원의 정보를 조회하여 리턴받은 UserDto 객체를 다시 UserDto 객체생성하여 담아준다.
		//여기에서 userIdCheck 라는 변수명으로 보내지만, 받는 service 쪽에서의 변수명은 달라도 된다.
		UserDto userDto = userService.getUserRead(userIdCheck);
		
		//UserDto객체가 null이 아닌경우(중복회원이 있는 경우) toString으로 담긴 정보 console창 표시 및 joinIdCheck false 처리
		if(userDto != null) {
			System.out.println("데이터베이스에서 조회 해온 한명 회원의 정보가 담긴 Dto (UserController.java) : " + userDto.toString());
			joinIdCheck = false;
		}
		
		return joinIdCheck;
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
