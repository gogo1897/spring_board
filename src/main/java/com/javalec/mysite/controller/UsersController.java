package com.javalec.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.javalec.mysite.service.IMySiteService;
import com.javalec.mysite.vo.UserVO;

@Controller
public class UsersController {
	
	@Autowired
	private IMySiteService mysiteService;
	
	
	@RequestMapping("/write.do")
	public String insertController(UserVO vo) {
		System.out.println("�Է���Ʈ�ѷ� WelComeController");
		
		//set�޼ҵ带 �������� �ڵ����� �������
		mysiteService.insertUser(vo);
		

		return "login.jsp";
	}
		
		@RequestMapping("/findpassword.do")
		public String findPasswordController(UserVO vo, Model model) {
			System.out.println("findpassword vo :" + vo.toString());
			
			model.addAttribute("findpwd",mysiteService.findPassword(vo));
			
			return "resultpassword.jsp";
			
	}
		
		@RequestMapping("/login.do")
		public String LoginController(UserVO vo, Model model,HttpSession session,HttpServletRequest req) {
			
			System.out.println("login: "+vo.toString());

			
			UserVO result = mysiteService.loginUser(vo);
			
			if(result!=null) {
				session.setAttribute("id", result.getId());
				return "selectall.do";
			} else {
				model.addAttribute("msg", "���̵��н����带Ȯ�����ּ���");
				return "login.jsp";
			}
		
		
		}
	
}
