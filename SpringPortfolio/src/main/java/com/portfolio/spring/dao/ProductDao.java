package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.ProductDto;

public interface ProductDao {

	public void insertNewProduct(ProductDto productDto);
	public void modifyProduct(ProductDto productDto);
	
	public int productTotalCnt();
	public int productTotalCnt_Admin();
	
	public int productTotalCateCnt(int cate);
	public int productTotalCateCnt_Admin(int cate);
	
	public int productSearchTotalCnt(String searchStr);
	public int productSearchTotalCnt_Admin(String searchStr);
	
	public int productSearchTotalCateCnt(String searchStr, int cate);
	public int productSearchTotalCateCnt_Admin(String searchStr, int cate);
	
	public ArrayList<ProductDto> productAllList(int startIdx, int endIdx);
	public ArrayList<ProductDto> productAllList_Admin(int startIdx, int endIdx);
	
	public ArrayList<ProductDto> productCateList(int startIdx, int endIdx, int cate);
	public ArrayList<ProductDto> productCateList_Admin(int startIdx, int endIdx, int cate);
	
	public ArrayList<ProductDto> productSearchAllList(int startIdx, int endIdx, String searchStr);
	public ArrayList<ProductDto> productSearchAllList_Admin(int startIdx, int endIdx, String searchStr);
	
	public ArrayList<ProductDto> productSearchCateList(int startIdx, int endIdx, String searchStr, int cate);
	public ArrayList<ProductDto> productSearchCateList_Admin(int startIdx, int endIdx, String searchStr, int cate);
	
	public ProductDto productDetail(int pd_idx);
	
	public void productDelete(int pd_idx);
	
	public void productPurchase(int pd_idx, int pd_purchase_count);
	public int productPurchaseResultCount(int pd_idx);
	
	public int checkProduct(int pd_idx);
	
}
