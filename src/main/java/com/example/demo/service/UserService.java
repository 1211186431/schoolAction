package com.example.demo.service;

import com.example.demo.dao.entity.User;

public interface UserService {
	/**
	 * 注册
	 * @param userInfo
	 * @return
	 */
	public String insertOne(User userInfo);
	
	/**
	 * 通过id获取用户信息
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);
	
	public String updateUser(User userInfo);
}
