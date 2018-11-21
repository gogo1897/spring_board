package com.javalec.mysite.service;

import java.util.List;

import com.javalec.mysite.vo.BoardVO;

public interface IMyBoardService {
	
	public void insert(BoardVO vo) ;
	public void update(BoardVO vo) ;
	public void delete(int no);
	public List<BoardVO> selectAll();
	public BoardVO selectOne(int no);
	public List<BoardVO> selectSearchTitle(String keyword);
	public List<BoardVO> selectSearchContent(String keyword);
	public int updateCnt(BoardVO vo);
}
