package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Service
public class AdminBoard_ServiceImpl implements AdminBoard_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminBoard_IDao dao;
	
	@Override
	public List<NaememberDto> userBasicInfo() {
		log.info("회원정보 조회 기본 userBasicInfo");
		return dao.userBasicInfo();
	}

	@Override
	public ProfileDto userDetail(String memberseq) {
		log.info("회원정보 조회 상세 userDetail, {}", memberseq);
		return dao.userDetail(memberseq);
	}

	@Override
	public List<FindingMentorDto> SearchRC() {
		log.info("신고게시글 조회 SearchRC");
		return dao.SearchRC();
	}

	@Override
	public boolean deleteReportAuto() {
		log.info("신고게시글 자동 삭제");
		return dao.deleteReportAuto();
	}

	@Override
	public List<NaememberDto> searchByeU() {
		log.info("탈퇴신청 회원 저회 searchByeU");
		return dao.searchByeU();
	}

	@Override
	public boolean changeStatusBye() {
		log.info("탈퇴신청 회원 계정 상태 변경 changeStatusBye");
		return dao.changeStatusBye();
	}

	@Override
	public boolean mentorPromotion(Map<String, String> map) {
		log.info("멘토승인시 권한 변경 mentorPromotion, {}", map);
		return dao.mentorPromotion(map);
	}

	@Override
	public boolean promotionDate(Map<String, String> map) {
		log.info("멘토 승급시 승급일 기록 promotionDate, {}", map);
		return dao.promotionDate(map);
	}

	@Override
	public List<NaememberDto> searchApplier() {
		log.info("멘토신청자 조회 searchApplier");
		return dao.searchApplier();
	}

	@Override
	public boolean mentorCancel(Map<String, String> map) {
		log.info("멘토신청자 거절시 filechk 상태 변경 mentorCancel, {}", map);
		return dao.mentorCancel(map);
	}

	@Override
	public String denyId(Map<String, String> map) {
		log.info("멘토신청 거절시 메일 보낼 아이디 찾기 denyId {}", map);
		return dao.denyId(map);
	}

	@Override
	public String searchReportCnt(Map<String, String> map) {
		log.info("신고당한 회원의 신고당한 횟수 조회 searchReportcnt, {}", map);
		return dao.searchReportCnt(map);
	}

	@Override
	public boolean tierPromotion(Map<String, String> map) {
		log.info("멘토 승급 회원의 티어 상승 tierPromotion, {}", map);
		return dao.tierPromotion(map);
	}

	@Override
	public boolean deleteReport(Map<String, String> map) {
		log.info("신고게시글 삭제 deleteReport, {}", map);
		return dao.deleteReport(map);
	}

	@Override
	public NaememberDto personalInfo(Map<String, String> map) {
		log.info("개인회원 기본 정보 조회 personalInfo, {}", map);
		return dao.personalInfo(map);
	}

	@Override
	public boolean authorChk(Map<String, String> map) {
		log.info("멘토 승급시 authorchk를 Y로 전환 authorChk, {}", map);
		return dao.authorChk(map);
	}

}
