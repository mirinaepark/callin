package com.callin.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callin.dao.UserMapper;
import com.callin.domain.UserDto;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	
	//회원 전체 조회
	public List<UserDto> getUserList() {
		return userMapper.getUserList();
	}
	public UserDto getUserRead(String userId) {
		return userMapper.getUserRead(userId);
	}
}
