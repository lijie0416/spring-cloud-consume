package com.zh.knowledge.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zh.knowledge.mapper.UserAttrMapper;
import com.zh.knowledge.mapper.UserMapper;
import com.zh.knowledge.pojo.User;
import com.zh.knowledge.pojo.UserAttr;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserAttrMapper userAttrMapper;	
	public List<User> getAll(){
		return userMapper.getAll();
	}
	
	@Transactional
	public void insert(){
		User user=new User();
		user.setLoginName("aa");
		user.setLoginPassword("123");
		user.setUserName("你好");
		
		userMapper.insert(user);
		User user1=new User();
		user1.setLoginName("aa");
		user1.setLoginPassword("123");
		user1.setUserName("你好");
		userMapper.insert(user);
	}
	
	public void insertUser (User user,UserAttr userAttr,Map<String,String> paramMap){
		user.setCreateTime(paramMap.get("createTimecreateTime"));
		 userMapper.insert(user);
		 if(user.getId()!=0){
			 userAttr.setCUserId(user.getId());
			 userAttr.setUserProvince(paramMap.get("userProvince"));
			 userAttrMapper.insert(userAttr);
		 }
	}
}
