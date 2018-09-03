package com.portfolio.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.spring.dao.UserDao;
import com.portfolio.spring.dao.VisitorBackDao;
import com.portfolio.spring.dao.VisitorDao;
import com.portfolio.spring.dto.VisitorBackDto;
import com.portfolio.spring.dto.VisitorDto;
import com.portfolio.spring.util.DEFINE;
import com.portfolio.spring.util.DEFINE.Statistics_State;

@Controller
public class MainController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String mainPage(HttpServletRequest req, Model model, Principal principal){
		
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("uid");
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		/*String welcome = (String)session.getAttribute("welcome");
		System.out.println("main welcome :: " + welcome);
		if(welcome == null) {
			session.setAttribute("welcome", "welcome");
		}*/
		
		visitorCheck(req);
		
		if(uid == null && principal != null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		return "mainPage";
		
	}
	
	
	public void visitorCheck(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		
		String uid = (String)session.getAttribute("uid");
		String welcome = (String) session.getAttribute("welcome");
		
		Collection<? extends GrantedAuthority> authority = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		if(authority.toString().equals("[ROLE_ADMIN]") == false) {
		
			if(uid != null && welcome != null) {
				System.out.println("로그인 방문자!!!");
				VisitorDao dao = sqlSession.getMapper(VisitorDao.class);
				
				String addr = req.getRemoteAddr();
				
				VisitorDto dto = new VisitorDto(uid, addr);
				
				if(addr.equals("127.0.0.1") == false) {
					dao.insertVisitor(dto);
				}
			}
			
			if(welcome == null) {
				System.out.println("그냥 방문자 !!!");
				session.setAttribute("welcome", "welcome");
				
				VisitorDao dao = sqlSession.getMapper(VisitorDao.class);
				
				String addr = req.getRemoteAddr();
				
				VisitorDto dto = new VisitorDto(uid, addr);
				
				if(addr.equals("127.0.0.1") == false) {
					dao.insertVisitor(dto);
				}
			}
		}
		
	}
	
	
	@RequestMapping("/statistics")
	public String statistics(@RequestParam(defaultValue="0") int state, HttpServletRequest req, Model model) {
		
		System.out.println("state ::: " + state);
		
		Statistics_State[] statistics = DEFINE.Statistics_State.values();
		
		/*System.out.println("name :: " + statistics[state].name());
		System.out.println("getStateName :: " + statistics[state].getStateName());
		System.out.println("getStateNum :: " + statistics[state].getStateNum());
		System.out.println("ordinal :: " + statistics[state].ordinal());
		System.out.println("statistics[state] :: " + statistics[state]);*/

		Calendar cal = Calendar.getInstance();

		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		String today = year + "-" + month + "-" + date;
		
		int todayValue = 0;
		int todayTotal = 0;
		
		VisitorDao dao = sqlSession.getMapper(VisitorDao.class);
		todayTotal = dao.countDayView();
		
		VisitorBackDao backDao = sqlSession.getMapper(VisitorBackDao.class);
		
		switch(statistics[state]) {
		
			case DAY_VIEW:{
				System.out.println("DAY_VIEW");	
				
				todayValue = dao.countDayViewGuest();
			
				break;
			}
			case DAY_LOGIN:{
				System.out.println("DAY_LOGIN");
				
				todayValue = dao.countDayViewLogin();
				
				break;
			}
			
		}
		
		/*ArrayList<VisitorBackDto> back = backDao.countDay();
		String dateTime =back.get(0).getDateTime(); 
				
		System.out.println(dateTime);
		
		String[] cut = dateTime.split(" ");
		String[] cut2 = cut[0].split("-");
		
		for(int i = 0;i<cut2.length;i++) {
			System.out.println(i + "/" + cut2[i]);
		}
		*/
		
		model.addAttribute("backDay", backDao.countDay());
		model.addAttribute("today", today);
		
		model.addAttribute("todayValue", todayValue);
		model.addAttribute("todayTotal", todayTotal);
		
		model.addAttribute("statistics", statistics);
		model.addAttribute("curState", statistics[state].ordinal());
		
		return "statistics";
	}

}
