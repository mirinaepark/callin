package com.callin.dao;


import org.apache.ibatis.annotations.Mapper;

import com.callin.domain.UserDto;

@Mapper
public interface UserMapper {
	
	// 한명 회원 정보 조회
	public UserDto getUserRead(String userId);
	
	// 한명 회원 회원가입
	public int joinUser(UserDto userDto);
	
	// 한명 회원 정보 수정
	public int updateUser(UserDto userDto);
}
