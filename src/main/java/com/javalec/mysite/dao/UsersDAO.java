package com.javalec.mysite.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.javalec.mysite.vo.UserVO;



@Repository("usersDao")
public class UsersDAO {
		
		
		@Autowired	
		private SqlSessionTemplate mybatis;
		
		
		public UserVO findPassword(UserVO vo) {
			
			return mybatis.selectOne("UsersDAO.getFindPassword", vo);
		
		}
		
		public void insert(UserVO vo)  {
			 System.out.println("voname :" +vo);
		mybatis.insert("UsersDAO.insert", vo);
		
		}		
		
		public UserVO loginUser(UserVO vo) {
			return mybatis.selectOne("UsersDAO.login", vo);
		}

		
		
		
	}

