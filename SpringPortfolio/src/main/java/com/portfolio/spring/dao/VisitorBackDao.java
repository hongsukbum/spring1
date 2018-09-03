package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.VisitorBackDto;

public interface VisitorBackDao {

	public void insertDay(VisitorBackDto dto);
	
	public ArrayList<VisitorBackDto> countDay();
	
}
