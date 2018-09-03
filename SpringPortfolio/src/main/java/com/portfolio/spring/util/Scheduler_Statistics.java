package com.portfolio.spring.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.portfolio.spring.dao.VisitorBackDao;
import com.portfolio.spring.dao.VisitorDao;
import com.portfolio.spring.dto.VisitorBackDto;

@Service 
public class Scheduler_Statistics {

	@Autowired
	private SqlSession sqlSession;
	
	/*@Scheduled(cron = "5 * * * * *")
	public void TestScheduler() {
		
		System.out.println("테스트");
		
	}*/
	
	
	@Scheduled(cron = "59 59 23 * * *")
	public void SchedulerDayViewDelete() {
		
		System.out.println("하루 방문자 데이터 저장 후 삭제.");
		
		VisitorDao dao = sqlSession.getMapper(VisitorDao.class);
		int totalView = dao.countDayView();
		int guestView = dao.countDayViewGuest();
		int loginView = dao.countDayViewLogin();
		
		
		// 하루 방문자 DB 추가.
		VisitorBackDao backDao = sqlSession.getMapper(VisitorBackDao.class);
		VisitorBackDto backDto = new VisitorBackDto(totalView, guestView, loginView);
		backDao.insertDay(backDto);
		
		// 하루 방문자 체크 DB 삭제.
		dao.deleteDayView();
		
		
		
	}
	
	
}
