package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.PurchaseStatusDto;

public interface PurchaseStatusDao {

	public String getStatusName(int ps_idx);
	
	public ArrayList<PurchaseStatusDto> getStatusList();
	
}
