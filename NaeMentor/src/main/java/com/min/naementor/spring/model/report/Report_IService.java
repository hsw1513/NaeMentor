package com.min.naementor.spring.model.report;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.ReportDto;

public interface Report_IService {
	/**
	 * 신고당한 회원 조회(searchReportU)
	 * @param boardseq
	 * @return 신고당한 회원 리스트(true 성공)
	 */
	public List<ReportDto> searchReportU();
	
	/**
	 * 신고당한 회원 카운트 증가(addReportCnt)
	 * @param 회원번호
	 * @return 카운트 증가 성공여부(true 성공)
	 */
	public boolean addReportCnt(Map<String, String> map);
	
	/**
	 * 신고당한 회원 카운트 증가시 신고체크 초기화(Y로)
	 * @param 회원번호
	 * @return 초기화 성공여부
	 */
	public boolean changeSingoChk(Map<String, String> map);

	
}
