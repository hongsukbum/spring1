package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.QnaCateDto;

public interface QnaCateDao {
	
	public ArrayList<QnaCateDto> getAllQnacate();	
	public ArrayList<QnaCateDto> getQnaCate(int qnac_idx); 
}
