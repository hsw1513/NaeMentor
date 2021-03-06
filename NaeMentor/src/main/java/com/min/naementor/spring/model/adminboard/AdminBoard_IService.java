package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface AdminBoard_IService {

	/**
	 * 회원정보조회 기본(userBasicInfo)
	 * @param 회원 권한
	 * @return 회원 기본 정보
	 */
	public List<NaememberDto> userBasicInfo();
	
	/**
	 * 회원정보조회 상세(userDetail)
	 * @param 회원 번호
	 * @return 회원프로필 정보
	 */
	public ProfileDto userDetail(String memberseq);
	
	/**
	 * 신고게시글 조회(SearchRC)
	 * @return 신고당한 게시글
	 */
	public List<FindingMentorDto> SearchRC();
	
	/**
	 * 신고게시글 삭제(deleteReportAuto)
	 * @param 신고당한 횟수
	 * @return 게시글 삭제 성공여부(true: 삭제)
	 */
	public boolean deleteReportAuto();
	
	/**
	 * 신고게시글 삭제(deleteReport)
	 * @param 신고당한 횟수
	 * @return 게시글 삭제 성공여부(true: 삭제)
	 */
	public boolean deleteReport(Map<String, String> map);
	
	/**
	 * 탈퇴신청 회원 조회(searchByeU)
	 * @return 탈퇴신청한 회원의 정보
	 */
	public List<NaememberDto> searchByeU();
	
	/**
	 * 회원의 계정 상태 변경(changeStatusBye)
	 * @param 탈퇴신청 여부
	 * @return 상태변경 성공 여부(true: 성공)
	 */
	public boolean changeStatusBye();
	
	/**
	 * 멘토승인시 권한 변경(mentorPromotion)
	 * @param 회원번호
	 * @return 멘토 승인시 권한 변경 여부(true: 성공)
	 */
	public boolean mentorPromotion(Map<String, String> map);
	
	/**
	 * 멘토 승급시 승급일 기록(promotionDate)
	 * @param 회원번호
	 * @return 멘토 승급일 기록 성공 여부(true: 성공)
	 */
	public boolean promotionDate(Map<String, String> map);
	
	/**
	 * 멘토신청자 조회
	 * @return 멘토 신청한 회원의 정보
	 */
	public List<NaememberDto> searchApplier();
	
	/**
	 * 멘토신청자 거절시 FILECHK 상태 변경
	 * @param 회원번호
	 * @return FILECHK 변경 성공 여부(true 성공)
	 */
	public boolean mentorCancel(Map<String, String> map);
	
	/**
	 * 멘토신청 거절시 메일 보낼 아이디 찾기
	 * @param 회원번호
	 * @return 거절당한 회원 아이디
	 */
	public String denyId(Map<String, String> map);
	

	/**
	 * 신고당한 회원의 신고당한 횟수 조회
	 * @param 신고당한 사람 회원번호
	 * @return 신고당한 횟수
	 */
	public String searchReportCnt(Map<String, String> map);
	
	/**
	 * 멘트 승급 회원의 티어 상승(N->B)
	 * @param 회원번호
	 * @return 티어 상승 성공여부
	 */
	public boolean tierPromotion(Map<String, String> map);
	
	/**
	 * 개인회원 기본 정보 조회
	 * @param 회원번호
	 * @return 회원하나의 기본정보
	 */
	public NaememberDto personalInfo(Map<String, String> map);
	
	/**
	 * 멘토 승급시 authorchk를 Y로 전환
	 * @param 회원번호
	 * @return 전환 성공 여부
	 */
	public boolean authorChk(Map<String, String> map);

}
