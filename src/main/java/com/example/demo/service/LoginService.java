package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.entity.UserExample;
import com.example.demo.dao.mapper.UserMapper;

/**
 * 登录
 * 
 * @author dy-xx
 *
 */
@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username); 
		List<User> userInfo = this.userMapper.selectByExample(example);
		if (userInfo.isEmpty()) {
			throw new UsernameNotFoundException("账号不存在");
		} else
			return userInfo.get(0);
	}

}
