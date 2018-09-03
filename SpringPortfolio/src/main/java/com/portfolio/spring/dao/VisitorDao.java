package com.portfolio.spring.dao;

import com.portfolio.spring.dto.VisitorDto;

public interface VisitorDao {

	public void insertVisitor(VisitorDto dto);
	
	public int countDayView();
	public int countDayViewLogin();
	public int countDayViewGuest();
	
	public void updateDayViewLogin();
	
	public void deleteDayView();
	
	
	
}
