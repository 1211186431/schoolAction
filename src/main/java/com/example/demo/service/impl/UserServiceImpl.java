package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dao.entity.User;
import com.example.demo.dao.entity.UserExample;
import com.example.demo.dao.mapper.UserMapper;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public String insertOne(User userInfo) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria(); 
		criteria.andUserNameEqualTo(userInfo.getUsername());  
        List<User> l=this.userMapper.selectByExample(example);
        if(l.isEmpty()) {
			BCryptPasswordEncoder encode= new BCryptPasswordEncoder(10);
			String password=encode.encode(userInfo.getPassword());
			userInfo.setPassword(password);
			this.userMapper.insert(userInfo); 
        	return "创建成功";
        }
        else {
        	return "用户名已存在";
        }
	}

	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		UserExample.Criteria criteria=example.createCriteria(); 
		criteria.andUserIdEqualTo(userId);  
        List<User> l=this.userMapper.selectByExample(example);
		return l.get(0);
	}

	@Override
	public String updateUser(User userInfo) {
		// TODO Auto-generated method stub
		this.userMapper.updateUser(userInfo);
		return "修改成功";
	}
	
	

}
