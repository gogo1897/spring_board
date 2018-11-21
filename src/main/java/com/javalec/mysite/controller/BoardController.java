package com.javalec.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.mysite.service.IMyBoardService;
import com.javalec.mysite.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private IMyBoardService myBoardService;

	@RequestMapping("/selectall.do")
	public String selectAll(BoardVO vo, Model model) {

		model.addAttribute("list", myBoardService.selectAll());

		return "getBoardList.jsp";

	}

	@RequestMapping("/delete.do")
	public String delete(BoardVO vo, @RequestParam(value = "seq") String seq) {
		if (seq == null || seq.isEmpty()) {
			return "selectall.do";
		} else {
			int no = Integer.parseInt(seq);
			myBoardService.delete(no);
		}
		return "selectall.do";
	}

	@RequestMapping("/insertboard.do")
	public String insert(BoardVO vo) {

		myBoardService.insert(vo);

		return "selectall.do";
	}

	@RequestMapping("/insertboardform.do")
	public String insertform() {

		return "insertBoard.jsp";
	}

	@RequestMapping("/getboard.do")
	public String getBoard(BoardVO vo, HttpServletRequest req, Model model) {

		String seq2 = req.getParameter("seq");
		if (seq2 == null || seq2.isEmpty()) {

			return "getBoard.jsp";
		} else {

			int seq = Integer.parseInt(seq2);
			myBoardService.updateCnt(vo);
			BoardVO getboard = myBoardService.selectOne(seq);

			model.addAttribute("getboard", getboard);
			return "getBoard.jsp";
		}
	}

	@RequestMapping("/modifyboard.do")
	public String modifyBoard(Model model, BoardVO vo) {

		myBoardService.update(vo);

		return "redirect:selectall.do";
	}

	@RequestMapping("/modifyboardform.do")
	public String modifyBoardForm(BoardVO vo, Model model, HttpServletRequest req) {

		String seq2 = req.getParameter("seq");

		if (seq2 == null || seq2.isEmpty()) {
			return "redirect:selectall.do";
		} else {
			int seq = Integer.parseInt(seq2);
			BoardVO getboard = myBoardService.selectOne(seq);

			model.addAttribute("getboard", getboard);
			return "modifyBoard.jsp";
		}
	}
	@RequestMapping("searchboard.do")
	public String searchBoard(BoardVO vo, Model model, HttpServletRequest req) {
		
		String condition = req.getParameter("searchCondition");
		String keyword = req.getParameter("searchKeyword");
		
		if(condition.equals("title")) {
			
		List<BoardVO> list = myBoardService.selectSearchTitle(keyword);
			model.addAttribute("list", list);
			System.out.println("list tostring :" +list.toString());
		
		return "getBoardList.jsp";	
		} else if(condition.equals("content")){
			
			List<BoardVO> list2 = myBoardService.selectSearchContent(keyword);
			model.addAttribute("list", list2);
			
		return "getBoardList.jsp";
		} else {
		
		return "selectall.do";
		}
		}

}

