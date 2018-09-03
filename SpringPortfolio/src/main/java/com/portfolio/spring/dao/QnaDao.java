package com.portfolio.spring.dao;

import java.util.ArrayList;
import com.portfolio.spring.dto.QnaDto;

public interface QnaDao {

	public void insertQna(QnaDto dto);
	public ArrayList<QnaDto> viewQnalist(String unick);
	public QnaDto viewQnaDetail(int qna_idx);
	public void updateQna(QnaDto dto);
	public void removeQna(int qna_idx);
	public ArrayList<QnaDto> adminViewQnalist();
	public void updateState(int qna_idx, int qna_state);
	public void insertUserReply(QnaDto dto);
	public ArrayList<QnaDto> viewReply(int qnac_idx,int qna_pd_idx);
}
