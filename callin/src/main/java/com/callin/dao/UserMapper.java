package com.callin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.callin.domain.UserDto;

@Mapper
public interface UserMapper {
	
	//회원 전체 조회
	public List<UserDto> getUserList();
	public UserDto getUserRead(String userId);
	
	//아이디 찾기
	
}
