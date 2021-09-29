package com.callin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callin.dao.UserMapper;
import com.callin.domain.UserDto;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	// 한명 회원 정보 조회
	public UserDto getUserRead(String userId) {
		// 화면에서 입력하여 보내준 회원 아이디
		System.out.println("한명 회원 정보 조회 (UserService.java) : " + userId);
		UserDto userDto = userMapper.getUserRead(userId);
		
		
		if(userDto != null) {
			System.out.println("데이터베이스에서 조회 해온 한명 회원의 정보가 담긴 Dto (UserService.java) : " + userDto.toString());
		}
		return userDto;
	}
	
	
}
