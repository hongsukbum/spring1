package com.portfolio.spring.controller;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.spring.dao.AdminBoardDao;
import com.portfolio.spring.dao.QnaCateDao;
import com.portfolio.spring.dao.QnaDao;
import com.portfolio.spring.dto.AdminBoardDto;
import com.portfolio.spring.dto.QnaCateDto;
import com.portfolio.spring.dto.QnaDto;

@Controller
public class QnaController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/qnalist")
	public String qnaList(Model model, HttpServletRequest req) {
		
		//권한얻어오기---------------------------
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		//-----------------------------------
		
		//int qna_qnac_idx = 0;
		
		HttpSession session = req.getSession();
		
		String unick = (String)session.getAttribute("unick");
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		
		//System.out.println(role.toString());
		
		//QnaCateDao c_dao = sqlSession.getMapper(QnaCateDao.class);	
		
		//c_dao.getAllQnacate();
		QnaCateDao c_dao = sqlSession.getMapper(QnaCateDao.class);
		
		if(role.toString().equals("[ROLE_ADMIN]")) {
			model.addAttribute("viewQnalist",dao.adminViewQnalist());	
			model.addAttribute("qna_qnac", c_dao.getAllQnacate());
		}
		else if(role.toString().equals("[ROLE_USER]")) {
			model.addAttribute("viewQnalist",dao.viewQnalist(unick));			
		}
		else {
			return "/";
		}
		
		return "/qna/qnaList";
		
	}
	
	@RequestMapping("/qnaView")
	public String qnaView(Model model, HttpServletRequest req) {
		
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx"));
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		
		model.addAttribute("viewQnaDetail", dao.viewQnaDetail(qna_idx));
		
		if(dao.viewQnaDetail(qna_idx).getQna_state() == 1) {
			AdminBoardDao a_dao = sqlSession.getMapper(AdminBoardDao.class);
			model.addAttribute("viewReply", a_dao.viewReply(qna_idx));
		}
		
		return "/qna/qnaView";
	}
	
	
	@RequestMapping("/qnaWrite")
	public String qnaWrite(HttpServletRequest req, Model model) {
			
		int qna_idx=0;
		int qna_qnac_idx = 0;
		
		
		String strQnaIdx = req.getParameter("qna_idx");
		
		QnaCateDao dao = sqlSession.getMapper(QnaCateDao.class);
		model.addAttribute("qna_qnac", dao.getAllQnacate());
		
		if(strQnaIdx != null) {
			qna_idx = Integer.parseInt(strQnaIdx);
			model.addAttribute("qna_idx", qna_idx);
			qna_qnac_idx = Integer.parseInt(req.getParameter("qna_qnac_idx"));
		}
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		
		
		model.addAttribute("qna_title", qna_title);
		model.addAttribute("qna_content", qna_content);
		model.addAttribute("qna_qnac_idx", qna_qnac_idx);
		
		
		return "/qna/qnaWrite";
	}
	
	
	@RequestMapping("/qnaWriteConfirm")
	public String qnaWriteConfirm(HttpServletRequest req, Model model) {
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		
		System.out.println(" qna write confirm title :: " + qna_title + " / content :: " + qna_content);
		
		int qna_qnac_idx = Integer.parseInt(req.getParameter("qnac_idx"));
		
		HttpSession session = req.getSession();
		String qna_unick = (String) session.getAttribute("unick");
		
		int qna_pd_idx = 0;
		int qna_state = 0;
		
		QnaDto dto = new QnaDto(qna_unick, qna_qnac_idx, qna_pd_idx, qna_state, qna_title, qna_content);
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.insertQna(dto);
		
		return "redirect:/qnalist";
	}
	
	@RequestMapping("/qnaModifyConfirm")
	public String qnaModifyConfirm(HttpServletRequest req, Model model) {
		
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx")); 
		
		System.out.println("qna Modify confirm idx :: " + qna_idx);
		
		String qna_title = req.getParameter("qna_title");
		String qna_content = req.getParameter("qna_content");
		int qna_qnac_idx = Integer.parseInt(req.getParameter("qnac_idx"));
		
		HttpSession session = req.getSession();
		
		String qna_unick = (String) session.getAttribute("unick");
		int qna_pd_idx = 0;
		int qna_state = 0;
				
		QnaDto dto = new QnaDto(qna_unick, qna_qnac_idx, qna_pd_idx, qna_state, qna_title, qna_content);
		
		dto.setQna_idx(qna_idx);
		
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.updateQna(dto);
		
		return "redirect:/qnalist";
	}
	
	@RequestMapping("/qnaRemove")
	public String qnaRemove(HttpServletRequest req) {
				
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx")); 
					
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		dao.removeQna(qna_idx);
		
		return "redirect:/qnalist";
	}
	
	@RequestMapping("/admin_replyWrite")
	public String admin_replyWrite(HttpServletRequest req, Model model) {
		
		int qna_idx =0;
		
		if(req.getParameter("qna_idx") != "") {
			qna_idx = Integer.parseInt(req.getParameter("qna_idx"));
		}
		System.out.println("인덱스 ::" + qna_idx);
		
		model.addAttribute("qna_idx", qna_idx);
		
		return "/qna/admin_replyWrite";
	}
	
	@RequestMapping("/admin_replyWriteConfirm")
	public String admin_replyWriteConfirm(HttpServletRequest req) {
		
		int qna_idx = Integer.parseInt(req.getParameter("qna_idx"));
		String ab_content = req.getParameter("ab_content");
		
		AdminBoardDto dto = new AdminBoardDto(qna_idx,ab_content);
		
		AdminBoardDao dao = sqlSession.getMapper(AdminBoardDao.class);
		
		dao.insert_abReply(dto);
		
		int qna_state = 1;
		
		QnaDao q_dao = sqlSession.getMapper(QnaDao.class);
		q_dao.updateState( qna_idx, qna_state);
		
		return "redirect:/qnalist";
	}
	
	@RequestMapping("/userReply")
	public String userReply(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("유저댓글");
		
		String qna_content = req.getParameter("product_reply");
		int qna_pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		HttpSession session = req.getSession();
		String qna_unick = (String) session.getAttribute("unick");
		
		QnaDto dto = new QnaDto();
		QnaDao dao = sqlSession.getMapper(QnaDao.class);
		
		dto.setQna_unick(qna_unick);
		dto.setQna_pd_idx(qna_pd_idx);
		dto.setQna_qnac_idx(4);
		dto.setQna_content(qna_content);
		dto.setQna_state(0);
		dto.setQna_title("none_title");
		
		dao.insertQna(dto);
		
		RequestDispatcher dis = req.getRequestDispatcher("/productDetail");
		try {
			dis.forward(req, res);
		}catch (Exception e) {
		}
		
		return null;
		//return "redirect:/productDetail";
	}
}