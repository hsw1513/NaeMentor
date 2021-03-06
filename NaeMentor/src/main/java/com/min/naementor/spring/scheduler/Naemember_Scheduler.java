package com.min.naementor.spring.scheduler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.min.naementor.spring.model.adminboard.AdminBoard_IService;
import com.min.naementor.spring.model.findingMentor.FindingMentor_IService;
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
	
	@Autowired
	private FindingMentor_IService fservice;
	
	// 탈퇴신청 회원 자동 삭제(하루에 한번)
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteMember() {
		log.info("탈퇴신청 회원 자동 삭제");
		service.changeStatusBye();
	}
	
	// 게시판 신고 5회 이상 글 자동 삭제(하루에 한번)
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteContent() {
		log.info("게시글 신고 5회 이상 글 자동 삭제");
		service.deleteReportAuto();
	}
	
	// 경고카운트 3회 이상 회원 자동으로 자격 정지(시간당 한번)
	@Scheduled(cron = "0 0 * * * *")
	public void stopSingoedMember() {
		log.info("경고카운트 3회 이상 회원 자동으로 자격 정지");
		rservice.stopSingoedMember();
	}
	
	// 6개월 접속 안한 회원 자동 휴면 전환(하루에 한번)
	@Scheduled(cron = "0 0 0 * * *")
	public void goToBed() {
		log.info("6개월 접속 안한 회원 자동 휴면 전환");
		nservice.goToBed();
	}
	
	// 정지회원 한달 후 액티브로 전환(하루에 한번)
	@Scheduled(cron = "0 0 0 * * *")
	public void wakeUpStop() {
		log.info("정지회원 한달 후 엑티브로 전환");
		nservice.wakeUpStop();
	}
	
	// 매칭 안된 글 이틀 후 삭제(이틀에 한번 작동)
	@Scheduled(cron = "0 0 0 1/2 * *")
	public void deleteNoMatching() {
		log.info("매칭 안될 글 이틀 후 삭제");
		fservice.deleteNoMatching();
	}
	
	// 멘토링 완료 후 삼일 뒤 글 삭제(3일에 한번 작동)
	@Scheduled(cron = "0 0 0 1/3 * *")
	public void deleteCompleteMatching() {
		log.info("멘토링 완료 휴 삼일 뒤 글 삭제");
		fservice.deleteCompleteMatching();
	}
	
	// 후기가 남겨진 글 삭제 (5분에 한번 작동)
	@Scheduled(cron = "0 0 0 * * *")
	public void updateComplete() {
		log.info("후기가 남겨진 글 삭제");
		fservice.updateComplete();
	}
	
	
}
