package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	
	@Select("SELECT * FROM UserProfile WHERE id = ${id}")
	UserProfile getUserProfile(@Param("id") String id);
	
	@Select("SELECT * FROM UserProfile")
	List<UserProfile> getUserProfileList();
	
	@Insert("INSERT INTO UserProfile VALUES(${id},${name},${phone},${address})") 
	int putUserProfile( @Param("id") String id
			          , @Param("name") String name
			          , @Param("phone") String phone
			          , @Param("address") String address);
	
	@Insert("UPDATE UserProfile SER name = ${name}, phone = ${phone}, address = ${address} WHERE id = ${id})") 
	int postUserProfile( @Param("id") String id
			, @Param("name") String name
			, @Param("phone") String phone
			, @Param("address") String address);
	
}
