package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.AdminBoardDto;

public interface AdminBoardDao {
	public void insert_abReply(AdminBoardDto dto);
	public ArrayList<String> viewReply(int qna_idx);
}
