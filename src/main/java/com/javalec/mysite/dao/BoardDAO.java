package com.javalec.mysite.dao;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.javalec.mysite.vo.BoardVO;




@Repository("boardDao")
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	public void insert(BoardVO vo) {
		
		 mybatis.insert("BoardDAO.insert", vo);
		 
	}

	
	public void update(BoardVO vo) {
		System.out.println(vo.toString()+" 3");
		mybatis.update("BoardDAO.update", vo);
		
	}

	
	public int delete(int no) {
		int result = mybatis.delete("BoardDAO.delete", no);
		return result;
	}

	public List<BoardVO> selectAll() {
		
		return mybatis.selectList("BoardDAO.selectAll");
	}

	
	public int updateCnt(BoardVO vo) {
		int result = mybatis.update("BoardDAO.updateCnt", vo);
		return result;
	}
	
	
	public BoardVO selectOne(int no) {
		return mybatis.selectOne("BoardDAO.selectOne", no);
	}

	
	public List<BoardVO> selectSearchTitle(String keyword) {
		return mybatis.selectList("BoardDAO.selectSearchTitle", "%" + keyword + "%");
	}

	
	public List<BoardVO> selectSearchContent(String keyword) {
		return mybatis.selectList("BoardDAO.selectSearchContent", "%" + keyword + "%");
	}
	
}
