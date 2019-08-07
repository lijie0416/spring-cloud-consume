package com.zh.knowledge.mapper;

import java.util.List;

import com.zh.knowledge.pojo.UserAttr;


public interface  UserAttrMapper {

	
	UserAttr getOne(Long id);

	void insert(UserAttr userAttr);

	void update(UserAttr userAttr);

	void delete(Long id);
}
