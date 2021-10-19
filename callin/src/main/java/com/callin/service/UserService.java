package com.callin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callin.dao.UserMapper;
import com.callin.domain.UserDto;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	// 로그인
	public Map<String, Object> userLogin(String userId, String userPw) {
		// 화면에서 입력하여 보내준 회원 아이디
		System.out.println("한명 회원 정보 조회 (UserService.java) : " + userId);
		UserDto userDto = userMapper.getUserRead(userId);

		// 로그인 성공여부 성공 : true / 실패 : false
		boolean loginCheck = false;
		
		// 로그인 성공여부와 한명 회원 정보를 담을 맵을 객체화
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 조회한 정보에서의 비번과 입력받은 비번 일치하면 로그인 성공 
		if (userDto != null) {
			if (userPw.equals(userDto.getUserPw())) {
				System.out.println("데이터베이스에서 조회 해온 한명 회원의 정보가 담긴 Dto (UserService.java) : " + userDto.toString());
				loginCheck = true;
				
				// 로그인 성공하여 조회한 한명 회원 정보 맵에 담아 리턴(session에 넣기 위해)
				resultMap.put("userDto", userDto);
			}
		}
		
		// 로그인 성공여부 맵에 담아 리턴
		resultMap.put("loginCheck", loginCheck);
		return resultMap;
	}
	
	// 중복 아이디 체크
	public boolean joinIdCheck(String userId) {
		//중복 아이디 체크를 위한 boolean타입 변수 선언
		boolean joinIdCheck = true;
		
		// 입력받은 아이디로 회원조회에 성공하면 = 중복아이디 있음
		UserDto userDto = userMapper.getUserRead(userId);
		
		//중복된 아이디가 있는경우 false로 변경한다.
		if(userDto != null) {
			System.out.println("데이터베이스에서 조회 해온 한명 회원의 정보가 담긴 Dto (UserController.java) : " + userDto.toString());
			joinIdCheck = false;
		}
		
		return joinIdCheck;
	}
	
	// 회원가입 처리
	public int joinUser(UserDto userDto) {
		// 주소, 상세주소, 참고사항 DTO에서 get하여 하나의 주소 문자열로 결합 
		String postCode		= userDto.getUserPostCode().trim();
		String addr 		= " "+userDto.getUserAddr().trim();
		String addrDetail 	= " "+userDto.getUserAddrDetail().trim();
		String addrExtra	= " "+userDto.getUserAddrExtra().trim();
		String lastAddr 	= postCode + addr + addrDetail + addrExtra;
		
		// 결합한 주소 문자열을 DTO의 userAddr에 세팅
		userDto.setUserAddr(lastAddr);
		
		System.out.println("결합 완성 된 주소 (UserService.java): " + userDto.getUserAddr());
		
		return userMapper.joinUser(userDto);
	}
	
	// 한명 회원 조회
	public UserDto getOneUserInfo(String userId) {
		return userMapper.getUserRead(userId);
	}
	
	// 회원 정보 수정
	public int updateUserInfo(UserDto userDto) {
		int result = userMapper.updateUser(userDto);
		
		if(userDto.getUserPostCode() != null && userDto.getUserAddrDetail() != null) {
			// 주소, 상세주소, 참고사항 DTO에서 get하여 하나의 주소 문자열로 결합 
			String postCode		= userDto.getUserPostCode().trim();
			String addr 		= " "+userDto.getUserAddr().trim();
			String addrDetail 	= " "+userDto.getUserAddrDetail().trim();
			String addrExtra	= " "+userDto.getUserAddrExtra().trim();
			String lastAddr 	= postCode + addr + addrDetail + addrExtra;
			
			// 결합한 주소 문자열을 DTO의 userAddr에 세팅
			userDto.setUserAddr(lastAddr);
			
			System.out.println("결합 완성 된 주소 (UserService.java): " + userDto.getUserAddr());
			result = userMapper.updateUser(userDto);
		}
		return result;
	}
}
