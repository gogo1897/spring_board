package com.javalec.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.javalec.mysite.dao.BoardDAO;
import com.javalec.mysite.vo.BoardVO;

@Service("myBoardService")
public class MyBoardService implements IMyBoardService {

	@Autowired
	BoardDAO dao = new BoardDAO();

	@Override
	public void insert(BoardVO vo) {

		System.out.println(vo.toString());
		dao.insert(vo);

	}

	@Override
	public void update(BoardVO vo) {
		System.out.println(vo.toString() + " 2");
		dao.update(vo);
	}

	@Override
	public void delete(int no) {
		dao.delete(no);
	}

	@Override
	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public BoardVO selectOne(int no) {

		return dao.selectOne(no);
	}

	@Override
	public List<BoardVO> selectSearchTitle(String keyword) {
		return dao.selectSearchTitle(keyword);
	}

	@Override
	public List<BoardVO> selectSearchContent(String keyword) {
		return dao.selectSearchContent(keyword);

	}

	@Override
	public int updateCnt(BoardVO vo) {
		return dao.updateCnt(vo);
	}

}
