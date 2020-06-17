package com.min.naementor.spring.model.review;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.ReviewDto;

public interface Review_IDao {
	/**
	 * 멘티가 멘토의 후기를 조회
	 * @param mentorseq(멘토의 회원번호)
	 * @return List<ReviewDto> (해당 멘토번호로 된 모든 후기)
	 */
	public List<ReviewDto> searchMStar(String mentorseq);
	/**
	 * 멘토가 멘티의 후기를 조회
	 * @param menteeseq(멘티의 회원번호)
	 * @return List<ReviewDto> (해당 멘티번호로 된 모든 후기)
	 */
	public List<ReviewDto> denyMSearch(String menteeseq);
	/**
	 * 멘토의 후기입력 조회
	 * @param boardseq
	 * @return boolean(true: 입력 가능)
	 */
	public boolean chkReviewMentor(String boardseq);
	/**
	 * 멘토의 후기 입력
	 * @param dto
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertReviewMentor(ReviewDto dto);
	/**
	 * 멘티의 누적별점 추가
	 * @param map(memberseq, menteeaccstar)
	 * @return boolean(true: 갱신 성공)
	 */
	public boolean updateMenteeAccStar(Map<String,String> map);
	/**
	 * 멘티의 후기입력 조회
	 * @param boardseq
	 * @return boolean(true: 입력 가능)
	 */
	public boolean chkReviewMentee(String boardseq);
	/**
	 * 멘티의 후기 입력
	 * @param dto
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertReviewMentee(ReviewDto dto);
	/**
	 * 멘토의 누적별점 추가
	 * @param map(memberseq, mentoaccstar)
	 * @return boolean(true: 갱신 성공)
	 */
	public boolean updateMentoAccStar(Map<String,String> map);
	/**
	 * 리뷰글이 모두 달렸는지 확인(200616 츄가)
	 * @param boardseq
	 * @return boolean(true: 2개의 리뷰글이 달림)
	 */
	public boolean chkReviewCount(String boardseq);
}
