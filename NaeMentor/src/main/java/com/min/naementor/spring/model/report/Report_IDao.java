package com.min.naementor.spring.model.report;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.ReportDto;

public interface Report_IDao {

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
	/**
	 * 신고가능여부 체크
	 * @param map(key: reviewseq(리뷰번호) / singomember(신고자 회원번호))
	 * @return boolean(true: 신고 가능)
	 */
	public boolean chkReport(Map<String,String> map);
	/**
	 * 신고하기
	 * @param dto(신고자, 신고대상, 신고내용, 후기글 번호, 매칭글 번호 )
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertReport(ReportDto dto);
	/**
	 * 신고를 위해 멘티가 남긴 후기번호 가져오기
	 * @param map(key: mentorseq / menteeseq)
	 * @return REVIEWSEQ
	 */
	public int findReviewOfMentor(Map<String, String> map);
	/**
	 * 신고를 위해 멘토가 남긴 후기번호 가져오기
	 * @param map(key: mentorseq / menteeseq)
	 * @return REVIEWSEQ
	 */
	public int findReviewOfMentee(Map<String, String> map);
	
}
