package com.portfolio.spring.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.spring.dao.UserDao;

@Controller
public class MainController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String mainPage(HttpServletRequest req, Model model, Principal principal){
		
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("uid");
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null && principal != null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		return "mainPage";
		
	}
	
}
