package com.callin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.callin.domain.ClassProgressDto;
import com.callin.domain.UserDto;

@Mapper
public interface AdminMapper {
	
	//회원 전체 조회
	public List<UserDto> getUserList();
	
	public ClassProgressDto getUserClass(String userId);
	
	
}
