package com.min.naementor.spring.model.report;

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
	public boolean changeSingoChk(Map<String, String> map) {
		log.info("신고당한 회원 신고체크 변경(Y) changeSingoChk, {}", map);
		return dao.changeSingoChk(map);
	}

}
