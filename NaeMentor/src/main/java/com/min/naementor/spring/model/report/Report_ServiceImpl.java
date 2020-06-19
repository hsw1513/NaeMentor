package com.min.naementor.spring.model.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.ReportDto;

@Service
public class Report_ServiceImpl implements Report_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Report_IDao dao;

	@Override
	public List<ReportDto> searchReportU() {
		log.info("신고당한 회원 조회 searchReportU");
		return dao.searchReportU();
	}

	@Override
	public boolean addReportCnt(Map<String, String> map) {
		log.info("신고당한 회원 카운트 증가 addReportCnt, {}", map);
		return dao.addReportCnt(map);
	}
	
	@Override
	public boolean stopSingoedMember() {
		log.info("경고 3회 이상 회원 자격정지 stopSingoedMember");
		return dao.stopSingoedMember();
	}

	@Override
	public boolean changeSingoChk(Map<String, String> map) {
		log.info("신고당한 회원 신고체크 변경(Y) changeSingoChk, {}", map);
		return dao.changeSingoChk(map);
	}

	@Override
	public boolean chkReport(Map<String, String> map) {
		log.info("신고여부 체크 chkReport, {}", map);
		return dao.chkReport(map);
	}

	@Override
	public boolean insertReport(ReportDto dto) {
		log.info("신고하기 insertReport, {}", dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("reviewseq", dto.getReviewseq());
		map.put("singomember", dto.getSingomember());
		if(dao.chkReport(map)) {
			return dao.insertReport(dto);
		}else {
			return false;
		}
	}

	@Override
	public int findReviewOfMentor(Map<String, String> map) {
		log.info("리뷰번호찾기 findReviewOfMentor, {}", map);
		return dao.findReviewOfMentor(map);
	}

	@Override
	public int findReviewOfMentee(Map<String, String> map) {
		log.info("리뷰번호찾기 findReviewOfMentee, {}", map);
		return dao.findReviewOfMentee(map);
	}

	

}
