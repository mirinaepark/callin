package com.callin.controller;

import java.util.Map;

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
import com.callin.service.UserService;

@Controller
public class UserController {

	// 의존성 주입
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
// ================================================================================================={ 로그인 관련 Controller } 
	// 로그인 화면으로 이동
	@GetMapping("/login")
	public String login(@RequestParam(name = "result"     , required = false)String result, Model model
					   ,@RequestParam(name = "resultId"   , required = false)String resultId
					   ,@RequestParam(name = "resultPw"   , required = false)String resultPw
					   ,@RequestParam(name = "joinSuccess", required = false)String joinSuccess) {
		model.addAttribute("title", "로그인화면");
		
		if (result != null) {
			model.addAttribute("result", result);
			model.addAttribute("resultId", resultId);
			model.addAttribute("resultPw", resultPw);
			System.out.println(result);
			System.out.println(resultId);
			System.out.println(resultPw);
		}

		model.addAttribute("joinSuccess", joinSuccess);
		return "userPage/login";
	}

	// 로그인 처리
	@PostMapping("/login")
	public String login(@RequestParam(name = "loginId", required = false) String loginId, HttpSession session,
						@RequestParam(name = "loginPw", required = false) String loginPw, RedirectAttributes redirectAttr) {
		System.out.println("입력받은 아이디 : "+loginId);
		System.out.println("입력받은 패스워드 : "+loginPw);

		// 1.회원이 있는 경우
		if (loginId != null && !"".equals(loginId) && loginPw != null && !"".equals(loginPw)) {
			Map<String, Object> resultMap = userService.userLogin(loginId, loginPw);
			
			// service 단에서 로그인 체크 로직처리 한 후 결과 값을 get()을 이용하여 꺼낸다.
			boolean loginCheck 	= (boolean) resultMap.get("loginCheck");
			UserDto userDto 	= (UserDto) resultMap.get("userDto");
			
			// session에 로그인한 회원의 정보 등록
			if (loginCheck) {
				session.setAttribute("SID", userDto.getUserId());
				session.setAttribute("SLEVEL", userDto.getUserLevel());
				session.setAttribute("SNAME", userDto.getUserName());
				return "redirect:/";
			}
		}

		// 2. 회원이 없다면 redirect:/login result => 등록된 정보가 없습니다.
		redirectAttr.addAttribute("result", "false");
		redirectAttr.addAttribute("resultId", loginId);
		redirectAttr.addAttribute("resultPw", loginPw);
		return "redirect:/login";
	}

	// 로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
// ================================================================================================={ 회원가입 관련 Controller }
	// 회원가입 화면으로 이동
	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("title", "회원가입");
		return "userPage/join";
	}

	// 회원가입 처리
	@PostMapping("/join")
	public String join(UserDto userDto, RedirectAttributes reAttr) {
		
		System.out.println("화면에서 입력받은 회원가입 정보 (UserController.java): " + userDto.toString());
		
		if(userDto != null) {
			userService.joinUser(userDto);
		}
		reAttr.addAttribute("joinSuccess", "joinSuccess");
		return "redirect:/login";
	}

	// 아이디 중복 체크하는 Ajax
	@RequestMapping(value = "/joinIdCheck", method = RequestMethod.POST)
	@ResponseBody
	public boolean joinIdCheck(@RequestParam(name = "userIdCheck", required = false) String userIdCheck) {

		System.out.println("화면에서 입력한 아이디 (UserController.java) : " + userIdCheck);

		// 한명 회원의 정보를 조회하여 리턴받은 UserDto 객체를 다시 UserDto 객체생성하여 담아준다.
		// 여기에서 userIdCheck 라는 변수명으로 보내지만, 받는 service 쪽에서의 변수명은 달라도 된다.
		boolean joinIdCheck = userService.joinIdCheck(userIdCheck);

		return joinIdCheck;
	}
// ================================================================================================={ 회원정보 수정 관련 Controller }
	
	@GetMapping("/updateInfo")
	public String updateInfo(@RequestParam(name="userId", required = false)String userId, Model model
							,@RequestParam(name="fail", required = false)String fail
							,@RequestParam(name="failId", required = false)String failId
							) {
		System.out.println("전체회원리스트에서 선택한 수정할 아이디 : " + userId);
		
		if(userId != null) {
			UserDto userDto = userService.getOneUserInfo(userId);
			model.addAttribute("userDto", userDto);
		}
		
		System.out.println("fail : " + fail);
		System.out.println("failId : " + failId);
		model.addAttribute("fail", fail);
		model.addAttribute("failId", failId);
		model.addAttribute("title", "회원정보수정");
		return "userPage/updateInfo";
	}
	
	@PostMapping("/updateInfo")
	public String updateInfo(Model model, UserDto userDto, RedirectAttributes reAttr) {
		System.out.println("수정완료한 회원정보 DTO (UserController.java)" + userDto);
		
		
		
		if(userDto != null) {
			userService.updateUserInfo(userDto);
			return "redirect:/userList";
		}
		
		@SuppressWarnings("null")
		String failId = userDto.getUserId();
		reAttr.addAttribute("failId", failId);
		reAttr.addAttribute("fail", "fail");
		return "redirect:/updateInfo";
	}
	
// ================================================================================================={ 아이디,비번 찾기 관련 Controller }
	// 아이디, 비밀번호 찾기
	@GetMapping("/idFind")
	public String idFind(Model model) {
		model.addAttribute("title", "아이디 찾기");
		return "userPage/idFind";
	}

	@PostMapping("/idFind")
	public String idFind(@RequestParam(name = "inputName", required = false) String name,
			@RequestParam(name = "inputEmail", required = false) String email) {
		System.out.println(name + "<<<<<<<<<<name");
		System.out.println(email + "<<<<<<<<<<email");
		return "userPage/login";
	}

	@GetMapping("/pwFind")
	public String pwFind(Model model) {
		model.addAttribute("title", "비밀번호 찾기");
		return "userPage/pwFind";
	}
// ================================================================================================={ 수업 관련 Controller }
	// 수업
	@GetMapping("/lesson")
	public String lesson(Model model) {
		model.addAttribute("title", "수업정보");
		return "userPage/lesson";
	}
	
	// 나의 수업
	@GetMapping("/myLesson")
	public String myLesson(Model model) {
		model.addAttribute("title", "나의 수업");
		return "userPage/myLesson";
	}

	// 나의 정보
	@GetMapping("/myInfo")
	public String myInfo(Model model) {
		model.addAttribute("title", "회원정보");
		return "userPage/myInfo";
	}

	// 수강신청
	@GetMapping("/lessonApply")
	public String lessonApply(Model model) {
		model.addAttribute("title", "수강신청");
		return "userPage/lessonApply";
	}

	// 결제
	@GetMapping("/payment")
	public String payment(Model model) {
		model.addAttribute("title", "결제");
		return "userPage/payment";
	}

	// 결제및수강내역
	@GetMapping("/lessonDetail")
	public String lessonDetail(Model model) {
		model.addAttribute("title", "수강/결제내역");
		return "userPage/lessonDetail";
	}
}
