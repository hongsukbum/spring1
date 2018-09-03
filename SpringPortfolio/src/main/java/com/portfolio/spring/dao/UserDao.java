package com.portfolio.spring.dao;

import java.util.ArrayList;

import com.portfolio.spring.dto.UserInfoDto;

public interface UserDao {

	public int checkUserId(String str);
	public int checkUserNick(String str);
	
	public void accountAdmin(UserInfoDto dto);
	
	public void joinUser(UserInfoDto dto);
	//public void joinUser(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender);
	
	public void modifyUser(UserInfoDto dto);
	//public void modifyUser(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender);
	
	public String userNick(String uid);
	public UserInfoDto userInfo(String uid);
	
	public int selectUserUidx(String uid);
	public String selectUserBag(String uid);
	public void updateInputBag(int uidx, String pd_idx);
	
	//석범 추가
		public ArrayList<UserInfoDto> userlist();
		public UserInfoDto userDetail(int uidx);
		public void userBan(int uidx);
	
}
