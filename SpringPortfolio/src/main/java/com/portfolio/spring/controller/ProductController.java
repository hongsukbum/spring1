package com.portfolio.spring.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.portfolio.spring.dao.ProductCateDao;
import com.portfolio.spring.dao.ProductDao;
import com.portfolio.spring.dao.ProductPurchaseBagDao;
import com.portfolio.spring.dao.PurchaseStatusDao;
import com.portfolio.spring.dao.QnaDao;
import com.portfolio.spring.dao.UserDao;
import com.portfolio.spring.dto.ProductDto;
import com.portfolio.spring.dto.ProductPurchaseBagDto;
import com.portfolio.spring.dto.PurchaseStatusDto;
import com.portfolio.spring.util.Paging;

@Controller
public class ProductController {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping("/product")
	public String product(@RequestParam(defaultValue="1") int curPage, HttpServletRequest req, Model model) {
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		String searchStr = req.getParameter("search");

		Collection<? extends GrantedAuthority> authority = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		System.out.println("product list authority :: " + authority.toString());
		
		int cate = 0;
		String strCate = req.getParameter("pd_pdc_idx");
		System.out.println("product cate : " + strCate);	// cate가 0 이면 리스트 전부, 
		if(strCate !=null) cate = Integer.parseInt(strCate);

		int listCnt = 0;
		Paging paging = null;

		if(searchStr == null) {
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productTotalCnt_Admin();
				}else {
					listCnt = dao.productTotalCnt();
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productTotalCateCnt_Admin(cate);
				}else {
					listCnt = dao.productTotalCateCnt(cate);
				}
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productFirstIdx() - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productAllList_Admin(startIdx, endIdx));
				}else {
					model.addAttribute("productList", dao.productAllList(startIdx, endIdx));
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productCateList_Admin(startIdx, endIdx, cate));
				}else {
					model.addAttribute("productList", dao.productCateList(startIdx, endIdx, cate));
				}
			}
			
		}else {
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productSearchTotalCnt_Admin(searchStr);
				}else {
					listCnt = dao.productSearchTotalCnt(searchStr);
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					listCnt = dao.productSearchTotalCateCnt_Admin(searchStr, cate);
				}else {
					listCnt = dao.productSearchTotalCateCnt(searchStr, cate);
				}
			}
			System.out.println("list cnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();// + dao.productSearhcFirstIdx(searchStr) - 1;
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			if(cate == 0) {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productSearchAllList_Admin(startIdx, endIdx, searchStr));
				}else {
					model.addAttribute("productList", dao.productSearchAllList(startIdx, endIdx, searchStr));
				}
			}else {
				if(authority.toString().equals("[ROLE_ADMIN]")) {
					model.addAttribute("productList", dao.productSearchCateList_Admin(startIdx, endIdx, searchStr, cate));
				}else {
					model.addAttribute("productList", dao.productSearchCateList(startIdx, endIdx, searchStr, cate));
				}
			}
		}
		
		
		// 기본 카테고리
		ProductCateDao cateDao = sqlSession.getMapper(ProductCateDao.class);		
		model.addAttribute("product_cate", cateDao.productCateList());
		model.addAttribute("selectCate", cate);
		
		model.addAttribute("pageName", "/product");
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("paging", paging);
		model.addAttribute("search", searchStr);
		
		return "product/productList";
		
	}
	
	
	@RequestMapping("/productDelete")
	public String productDelete(HttpServletRequest req) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		dao.productDelete(pd_idx);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/productDetail")
	public String productDetail(HttpServletRequest req, Model model){
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		String isCheck = req.getParameter("isCheck");
		String index = req.getParameter("index");
		
		System.out.println("product detail isCheck :: " + isCheck);
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
						
		model.addAttribute("productDetail", dao.productDetail(pd_idx));
		model.addAttribute("isCheck", isCheck);
		model.addAttribute("index", index);

		//------석범추가------------
		System.out.println("디테일");
		
		HttpSession session = req.getSession();
		model.addAttribute("pd_reply_unick", (String)session.getAttribute("unick"));
		
		QnaDao q_dao = sqlSession.getMapper(QnaDao.class);
		model.addAttribute("viewReplylist", q_dao.viewReply(4,pd_idx));	
		
		return "product/productDetail";
		
	}
	
	
	@RequestMapping("/productModifyConfirm")
	public String productModifyConfirm(MultipartHttpServletRequest req, MultipartFile mf) {
		
		System.out.println("수정완료? :: " + req.getParameter("pd_idx"));
		
		String pd_name = req.getParameter("pd_name");
		String pd_title = req.getParameter("pd_title");
		String pd_content = req.getParameter("pd_content");
		int pd_charge = Integer.parseInt(req.getParameter("pd_charge"));
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
		int pd_pdc_idx = Integer.parseInt(req.getParameter("pd_pdc_idx"));
		
		// 파일 업로드
		String imagePath = "uploadFile/product";
		
		mf = req.getFile("pd_image");
		String path = req.getRealPath(imagePath);
		String fileName = mf.getOriginalFilename();
		
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
		
		File uploadFile = new File(path + "//" + fileName);
		
		try {
			mf.transferTo(uploadFile);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDto dto = new ProductDto(pd_name, pd_title, pd_content, imagePath ,fileName, pd_charge, pd_count, pd_pdc_idx, 0);
		dto.setPd_idx(Integer.parseInt(req.getParameter("pd_idx")));	
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.modifyProduct(dto);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/product_enrollment")
	public String product_enrollment(HttpServletRequest req, Model model) {
		
		String pd_idx = req.getParameter("pd_idx");
		
		ProductCateDao cateDao = sqlSession.getMapper(ProductCateDao.class);		
		model.addAttribute("product_cate", cateDao.productCateList());
		
		if(pd_idx != null) {
		
			ProductDao dao = sqlSession.getMapper(ProductDao.class);
			
			model.addAttribute("productDetail", dao.productDetail(Integer.parseInt(pd_idx)));
		}
			
		return "product/product_enrollmentPage";
		
	}
	
	
	@RequestMapping("/product_enrollmentConfirm")
	public String product_enrollmentConfirm(MultipartHttpServletRequest req, MultipartFile mf){
		
		System.out.println("등록완료?!?!");
		
		String pd_name = req.getParameter("pd_name");
		String pd_title = req.getParameter("pd_title");
		String pd_content = req.getParameter("pd_content");
		int pd_charge = Integer.parseInt(req.getParameter("pd_charge"));
		int pd_count = Integer.parseInt(req.getParameter("pd_count"));
		int pd_pdc_idx = Integer.parseInt(req.getParameter("pd_pdc_idx"));
		
		// 파일 업로드
		String imagePath = "uploadFile/product";
		
		mf = req.getFile("pd_image");
		String path = req.getRealPath(imagePath);
		String fileName = mf.getOriginalFilename();
		
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
		
		File uploadFile = new File(path + "//" + fileName);
		
		try {
			mf.transferTo(uploadFile);
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDto dto = new ProductDto(pd_name, pd_title, pd_content, imagePath ,fileName, pd_charge, pd_count, pd_pdc_idx, 0);

		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.insertNewProduct(dto);
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/productPurchaseCheck")
	public String productPurchaseCheck(HttpServletRequest req, Model model) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		
		System.out.println("purchase check pd_idx :: " + pd_idx);
		
		int pd_purchase_count = Integer.parseInt(req.getParameter("pd_purchase_count"));
		String isBag = req.getParameter("isBag");
		System.out.println("purchase check :: isBag :: " + isBag);
		
		int pd_charge = Integer.parseInt(req.getParameter("pd_charge"));
		
		String index = req.getParameter("index");
		
		model.addAttribute("index", index);
		model.addAttribute("pd_charge", pd_charge);
		model.addAttribute("isBag", isBag);
		model.addAttribute("pd_idx", pd_idx);
		model.addAttribute("pd_purchase_count", pd_purchase_count);
		
		return "/product/productPurchaseCheck";
		
	}
	
	
	@RequestMapping("/productPurchase")
	public String productPurchase(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		int pd_purchase_count = Integer.parseInt(req.getParameter("pd_purchase_count"));
		
		String isBag = req.getParameter("isBag");
		String result="";

		String index = req.getParameter("index");
		
		if(isBag.equals("purchaseBag")) {
			System.out.println("구매내역에서 구매");
			result = "redirect:productPurchaseBag";
		}else if(isBag.equals("") == false) {
			result = "redirect:productBag";
			model.addAttribute("pd_idx", pd_idx);
			model.addAttribute("index", index);
		}else {
			result = "redirect:product";
		}
		
		System.out.println("purchase isBag :: " + isBag);
		
		System.out.println(" purchase pd_idx :: " + pd_idx);
		System.out.println("purchase pd count :: " + pd_purchase_count);
		// 상품 수량 줄이고 판매수량 올리고 가방에 넣어줘야함.
		// 가방에 넣는거 추가해야함.
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		dao.productPurchase(pd_idx, pd_purchase_count);
		
		/*int n = dao.productPurchaseResultCount(pd_idx);
		
		System.out.println("남은 수량 :: " + n);*/
		
		// 구매내역 추가.
		ProductPurchaseBagDto bagDto = new ProductPurchaseBagDto(uid, pd_idx, pd_purchase_count);
		
		ProductPurchaseBagDao bagDao = sqlSession.getMapper(ProductPurchaseBagDao.class);
		bagDao.purchaseProduct(bagDto);
		
		return result;
		
	}
	
	
	@RequestMapping("/productInputBag")
	public String productInputBag(HttpServletRequest req, Principal principal) {
		
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		String tmpIdx = pd_idx + ",";
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		UserDao dao = sqlSession.getMapper(UserDao.class);
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
			session.setAttribute("unick", dao.userNick(uid));
		}
		
		System.out.println("Input bag pd_idx :: " + pd_idx + " / tmpIdx :: " + tmpIdx + " / uid :: " + uid);
		
		// userinfo 에 ubagid 에 넣어줘...    , 로 구분하자.
		
		int uidx = dao.selectUserUidx(uid);
		
		tmpIdx = tmpIdx + dao.selectUserBag(uid);
		
		dao.updateInputBag(uidx, tmpIdx);
		
		return "redirect:product";
		
	}
	
	
	@RequestMapping("/productBag")
	public String productBag(@RequestParam(defaultValue="1") int curPage, HttpServletRequest req, HttpServletResponse res, Model model, Principal principal) {
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
		}
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		String userBag = userDao.selectUserBag(uid);
		int uidx = userDao.selectUserUidx(uid);
		
		
		///////////////////////////////
		if(req.getParameter("pd_idx") != null) {
			RequestDispatcher dis = req.getRequestDispatcher("/productUserBagDelete");
			try {
				dis.forward(req, res);
			}catch (Exception e) {
			}
			userBag = userDao.selectUserBag(uid);
		}
		
		System.out.println("productBag userBag :: " + userBag);
		
		String[] strBag = null;
		Paging paging = new Paging(0, curPage);
		
		if(userBag.equals("") == false){
			strBag = userBag.split(",");
		
			String searchStr = req.getParameter("search");
			int listCnt = 0;
			
			
			System.out.println("bag search :: " + searchStr);
		
			listCnt = strBag.length;
		
			System.out.println("listCnt : " + listCnt);
			
			paging = new Paging(listCnt, curPage);
			
			int startIdx = paging.getStartIndex();
			int endIdx = paging.getPageSize();
			
			System.out.println("start : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			// .... 가져와
			model.addAttribute("bagList", selectUserBagList(uidx, userBag, strBag, listCnt, startIdx, endIdx));
		
		}
		
		//model.addAttribute("bagList", bagList);
		
		model.addAttribute("pageName", "/productBag");
		model.addAttribute("paging", paging);
		
		return  "product/productBag";
		
	}
	
	
	public ArrayList<ProductDto> selectUserBagList(int uidx, String userBag, String[] strBag, int listCnt, int startIdx, int endIdx){
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		ProductDao productDao = sqlSession.getMapper(ProductDao.class);
		ArrayList<ProductDto> bagList = new ArrayList<ProductDto>();
		
		if(userBag.equals("") == false){
			
			ProductDto dto = new ProductDto();
			
			int result = 0;
			userBag = "";
			// strBag의 값의 상품이 존재하는지 확인해서 다시만들어 ~ 
			for(int i = 0;i<strBag.length;i++) {
				result = productDao.checkProduct(Integer.parseInt(strBag[i]));
				if(result !=0) {
					userBag += (strBag[i] + ","); 
				}
			}
			
			strBag = userBag.split(",");
			userDao.updateInputBag(uidx, userBag);
			
			endIdx = startIdx + endIdx;
			if(endIdx > listCnt) {
				endIdx = listCnt;
			}
			
			for(int i = startIdx;i<endIdx;i++) {
				dto = productDao.productDetail(Integer.parseInt(strBag[i]));
				if(dto != null)
					bagList.add(dto);
			}
		}
		
		return bagList;
		
	}
	
	
	@RequestMapping("/productUserBagDelete")
	public String productUserBagDelete(HttpServletRequest req, Principal principal) {
		
		System.out.println("delete index : " + req.getParameter("index") + " / pd_idx  : " + req.getParameter("pd_idx"));
		int index = Integer.parseInt(req.getParameter("index"));
		int pd_idx = Integer.parseInt(req.getParameter("pd_idx"));
		String tmpIdx = "";
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		if(uid == null) {
			uid = principal.getName();
			
			session.setAttribute("uid", uid);
		}
		
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		int uidx = userDao.selectUserUidx(uid);
		
		String userBag = userDao.selectUserBag(uid);
		
		System.out.println("index : " + index + " / pd_idx : " + pd_idx);
		System.out.println("delete userBag :: " + userBag);
		
		// 문자열 찾아서 삭제 인덱스로
		{
			String[] arrUserBag = userBag.split(",");

			for(int i = 0;i<arrUserBag.length;i++) {
				if(i != index)
					tmpIdx += (arrUserBag[i] + ",");
			}
		}
		
		System.out.println("result userBag :: " + tmpIdx);
		
		userDao.updateInputBag(uidx, tmpIdx);
		
		return "redirect:productBag";
		
	}
	
	/////////////////////////
	
	@RequestMapping("/productPurchaseBag")
	public String productPurchaseBag(@RequestParam(defaultValue="1") int curPage, HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		
		
		ProductPurchaseBagDao bagDao = sqlSession.getMapper(ProductPurchaseBagDao.class);
		ArrayList<ProductPurchaseBagDto> purchaseBagList = new ArrayList<ProductPurchaseBagDto>();
		
		int listCnt = bagDao.productTotalCnt(uid);
		Paging paging = new Paging(listCnt, curPage);
		
		int startIdx = paging.getStartIndex();
		int endIdx = paging.getPageSize();
		
		System.out.println("uid :: " + uid);
		purchaseBagList = bagDao.productAllList(uid, startIdx, endIdx);
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		int pd_idx = 0;
		ProductDto dto = new ProductDto();
		
		PurchaseStatusDao psDao = sqlSession.getMapper(PurchaseStatusDao.class);
		
		for(int i =0 ;i<purchaseBagList.size();i++) {
			pd_idx = purchaseBagList.get(i).getPdb_pdidx();
			
			dto = dao.productDetail(pd_idx);
			
			purchaseBagList.get(i).setPd_name(dto.getPd_name());
			purchaseBagList.get(i).setPd_charge(dto.getPd_charge());
			purchaseBagList.get(i).setPs_name(psDao.getStatusName(purchaseBagList.get(i).getPdb_state()));
			
		}
		
		System.out.println("listcnt ; "  + listCnt);
		
		model.addAttribute("purchaseBag", purchaseBagList);
		model.addAttribute("pageName", "/productPurchaseBag");
		model.addAttribute("paging", paging);
		model.addAttribute("purchaseStatusList", psDao.getStatusList());
		//model.addAttribute("purchaseBag", purchaseBagList);
		
		return "product/productPurchaseBag";
		
	}
	
	
	@RequestMapping("/productPurchaseBag_Admin")
	public String productPurchaseBag_Admin(@RequestParam(defaultValue="1") int curPage, HttpServletRequest req, Model model) {
		
		ProductPurchaseBagDao bagDao = sqlSession.getMapper(ProductPurchaseBagDao.class);
		ArrayList<ProductPurchaseBagDto> purchaseBagList = new ArrayList<ProductPurchaseBagDto>();
		
		int listCnt = bagDao.productTotalCnt_Admin();
		Paging paging = new Paging(listCnt, curPage);
		
		int startIdx = paging.getStartIndex();
		int endIdx = paging.getPageSize();
		
		purchaseBagList = bagDao.productAllList_Admin(startIdx, endIdx);
		
		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		
		int pd_idx = 0;
		ProductDto dto = new ProductDto();
		
		PurchaseStatusDao psDao = sqlSession.getMapper(PurchaseStatusDao.class);
		
		for(int i =0 ;i<purchaseBagList.size();i++) {
			pd_idx = purchaseBagList.get(i).getPdb_pdidx();
			
			dto = dao.productDetail(pd_idx);
			
			purchaseBagList.get(i).setPd_name(dto.getPd_name());
			purchaseBagList.get(i).setPd_charge(dto.getPd_charge());
			purchaseBagList.get(i).setPs_name(psDao.getStatusName(purchaseBagList.get(i).getPdb_state()));
		}
		
		System.out.println("listcnt ; "  + listCnt);
		
		model.addAttribute("purchaseBag", purchaseBagList);
		model.addAttribute("pageName", "/productPurchaseBag_Admin");
		model.addAttribute("paging", paging);
		model.addAttribute("purchaseStatusList", psDao.getStatusList());
		
		return "product/productPurchaseBag";
		
	}
	
	
	@RequestMapping("/purchaseStatusUpdate")
	public String purchaseStatusUpdate(HttpServletRequest req, HttpServletResponse res) {
		
		String pdb_idx = req.getParameter("pdb_idx");
		String purchaseStatus = req.getParameter("purchaseStatus");
		
		System.out.println("purchaseStatus :: " + purchaseStatus);
		
		ProductPurchaseBagDao dao = sqlSession.getMapper(ProductPurchaseBagDao.class);
		dao.updatePurchaseStatus(Integer.parseInt(pdb_idx), Integer.parseInt(purchaseStatus));
		
		return "redirect:productPurchaseBag_Admin";
		
	}

	
}
