package com.zh.knowledge.mapper;

import java.util.List;

import com.zh.knowledge.pojo.User;

public interface  UserMapper {

	List<User> getAll();
	
	User getOne(Long id);

	int insert(User user);

	void update(User user);

	void delete(Long id);
}
