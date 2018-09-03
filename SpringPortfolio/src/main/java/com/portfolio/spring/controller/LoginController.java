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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.spring.dao.UserDao;
import com.portfolio.spring.dto.UserInfoDto;

@Controller
public class LoginController {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/loginok")
	public String loginok(HttpServletRequest req, Principal principal) {
		
		System.out.println("login ok : " + principal.getName());
		
		HttpSession session = req.getSession();
		String uid = principal.getName();
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		session.setAttribute("uid", uid);
		session.setAttribute("unick", dao.userNick(uid));
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/login")
	public String loginPage(@RequestParam(value="joinUid", defaultValue = "")String joinUid, Model model) {
		
		System.out.println("join uid : " + joinUid);
		
		model.addAttribute("joinUid", joinUid);
		
		return "security/loginPage";
		
	}
	
	
	@RequestMapping("/join")
	public String joinPage(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		String unick = req.getParameter("unick");

		String checkIdPopupReturn = req.getParameter("checkIdPopupReturn");
		String checkNickPopupReturn = req.getParameter("checkNickPopupReturn");
		
		System.out.println("join check uid :: " + uid);
		System.out.println("join check unick :: " + unick);
		
		System.out.println("join check checkIdPopupReturn :: " + checkIdPopupReturn);
		System.out.println("join check checkNickPopupReturn :: " + checkNickPopupReturn);
		
		req.setAttribute("uid", uid);
		req.setAttribute("unick", unick);
		
		req.setAttribute("checkIdPopupReturn", checkIdPopupReturn);
		req.setAttribute("checkNickPopupReturn", checkNickPopupReturn);
		
		return "user/joinPage";
		
	}
	
	
	@RequestMapping("/checkUserId")
	public String checkUserId(HttpServletRequest req, Model model) throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		int n = dao.checkUserId(uid);
		
		System.out.println(uid + "checkIdResult 0 사용가능 :: " + n);
		
		req.setAttribute("checkIdResult", n);
		
		return "user/checkUser";
		
	}
		
	
	@RequestMapping("/checkUserNick")
	public String checkUserNick(HttpServletRequest req, Model model) throws UnsupportedEncodingException {

		req.setCharacterEncoding("UTF-8");
		
		String unick = req.getParameter("unick");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		int n = dao.checkUserNick(unick);
		
		System.out.println(unick + "checkNickResult 0 사용가능 :: " + n);
		
		req.setAttribute("checkNickResult", n);
		
		return "user/checkUser";
		
	}
	
	
	@RequestMapping("/joinConfirm")
	public String joinConfirm(UserInfoDto userInfoDto, HttpServletRequest req, Model model, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("joinConfirm");
		
		System.out.println(" dto uid : " + userInfoDto.getUid());
		System.out.println(" dto unick : " + userInfoDto.getUnick());
		
		String uphone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		
		userInfoDto.setUphone(uphone);
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.joinUser(userInfoDto);
		
		redirectAttributes.addAttribute("joinUid", userInfoDto.getUid());
		
		/*String uid = req.getParameter("uid");
		String upw = req.getParameter("upw");
		String unick = req.getParameter("unick");
		String uphone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		String uaddr = req.getParameter("uaddr");
		String ubirth = req.getParameter("ubirth");
		String ugender = req.getParameter("ugender");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.joinUser(uid, upw, unick, uphone, uaddr, ubirth, ugender);
		
		redirectAttributes.addAttribute("joinUid", uid);*/
		
		return "redirect:login";
		
	}
	
	
	@RequestMapping("/userinfoPage")
	public String userinfoPage(HttpServletRequest req, Model model, Principal principal) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String uid = (String)session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		System.out.println("user modify uid :: " + uid);
		
		model.addAttribute("userInfo", dao.userInfo(uid));
		
		return "user/userinfoPage";
		
	}
	
	
	@RequestMapping("/userinfoModifyPage")
	public String userinfoModifyPage(HttpServletRequest req, Model model, Principal principal) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
	
		HttpSession session = req.getSession();
		
		String uid = (String) session.getAttribute("uid");
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		System.out.println(" modify uid :: " + uid);
		
		model.addAttribute("userInfo", dao.userInfo(uid));
		
		return "user/userinfoModifyPage";
		
	}
	
	
	@RequestMapping("/userModifyConfirm")
	public String userModifyConfirm(UserInfoDto userInfoDto, HttpServletRequest req, Model model, Principal principal) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String uid = (String) session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			
		}
		
		/*String upw = req.getParameter("upw");
		String unick = req.getParameter("unick");
		String uphone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		String uaddr = req.getParameter("uaddr");
		String ubirth = req.getParameter("ubirth");
		String ugender = req.getParameter("ugender");*/

		String uphone = req.getParameter("phone1") + "-" + req.getParameter("phone2") + "-" + req.getParameter("phone3");
		
		userInfoDto.setUphone(uphone);
		userInfoDto.setUid(uid);
		
		System.out.println("uid : " + userInfoDto.getUid());
		System.out.println("upw : " + userInfoDto.getUpw());
		System.out.println("unick : " + userInfoDto.getUnick());
		System.out.println("uphone : " + userInfoDto.getUphone());
		System.out.println("uaddr : " + userInfoDto.getUaddr());
		System.out.println("ubirth : " + userInfoDto.getUbirth());
		System.out.println("ugender : " + userInfoDto.getUgender());
		
		dao.modifyUser(userInfoDto);
		
		//dao.modifyUser(uid, upw, unick, uphone, uaddr, ubirth, ugender);
		
		session.setAttribute("unick", dao.userNick(uid));
		
		return "redirect:/userinfoPage";
		
	}
	
	
}
