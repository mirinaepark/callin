package com.callin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callin.dao.AdminMapper;
import com.callin.domain.ClassProgressDto;
import com.callin.domain.UserDto;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	//회원 전체 조회
	public List<UserDto> getUserList() {
		return adminMapper.getUserList();
	}
	
	//한명 학생의 수업정보 조회
	public ClassProgressDto getUserClass(String userId) {
		return adminMapper.getUserClass(userId);
	}
}
