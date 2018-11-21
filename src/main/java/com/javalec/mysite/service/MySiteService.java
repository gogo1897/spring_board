package com.javalec.mysite.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.javalec.mysite.dao.UsersDAO;
import com.javalec.mysite.vo.UserVO;

@Service("mysiteService")
public class MySiteService implements IMySiteService {
	
	@Autowired

	private UsersDAO dao;
	
	@Override
	public void insertUser(UserVO vo) {
		
		System.out.println("voname: "+ vo);
		
		dao.insert(vo);
	}
	@Override
	public UserVO findPassword(UserVO vo) {
		
		 return dao.findPassword(vo);
		
	}
	
	@Override
	public UserVO loginUser(UserVO vo) {
		
		return dao.loginUser(vo);				
		
	
	}
}
