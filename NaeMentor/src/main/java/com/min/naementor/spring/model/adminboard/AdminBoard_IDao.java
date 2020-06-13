package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface AdminBoard_IDao {

	/**
	 * 회원정보조회 기본(userBasicInfo)
	 * @param 회원 권한
	 * @return 회원 기본 정보 조회
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
	 * 신고게시글 삭제(deleteReport)
	 * @param map
	 * @return 게시글 삭제 성공여부(true: 삭제)
	 */
	public boolean deleteReport(Map<String, String> map);
	
	/**
	 * 탈퇴신청 회원 조회(searchByeU)
	 * @return 탈퇴신청한 회원의 정보
	 */
	public List<NaememberDto> searchByeU();
	
	/**
	 * 회원의 계정 상태 변경(changeStatus)
	 * @param 유저 상태, 회원번호
	 * @return 상태변경 성공 여부(true: 성공)
	 */
	public boolean changeStatus(NaememberDto dto);
	
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
	
	
	
	
}
