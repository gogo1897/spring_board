package com.javalec.mysite.service;



import com.javalec.mysite.vo.UserVO;

public interface IMySiteService {
	
	public void insertUser(UserVO vo);
	public UserVO findPassword(UserVO vo);
	public UserVO loginUser(UserVO vo);

	
	
}
