package com.min.naementor.spring.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.min.naementor.spring.model.adminboard.AdminBoard_IService;
import com.min.naementor.spring.model.naemember.Naemember_IService;
import com.min.naementor.spring.model.report.Report_IService;

@Component
public class Naemember_Scheduler {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Naemember_IService nservice;
	
	@Autowired
	private AdminBoard_IService service;
	
	@Autowired
	private Report_IService rservice;
	
	// 탈퇴신청 회원 자동 삭제
//	@Scheduled(cron = "0/5 * * * * *")
	public void deleteMember() {
		service.changeStatusBye();
	}
	
	// 게시판 신고 5회 이상 글 자동 삭제
//	@Scheduled(cron = "0/5 * * * * *")
	public void deleteContent() {
		service.deleteReport();
	}
	
	// 경고카운트 3회 이상 회원 자동으로 자격 정지
//	@Scheduled(cron = "0/5 * * * * *")
	public void stopSingoedMember() {
		rservice.stopSingoedMember();
	}
	
	// 6개월 접속 안한 회원 자동 휴면 전환
//	@Scheduled(cron = "0/5 * * * * *")
	public void goToBed() {
		nservice.goToBed();
	}
	
	// 정지회원 한달 후 액티브로 전환
//	@Scheduled(cron = "0/5 * * * * *")
	public void wakeUpStop() {
		nservice.wakeUpStop();
	}
	
	
}
