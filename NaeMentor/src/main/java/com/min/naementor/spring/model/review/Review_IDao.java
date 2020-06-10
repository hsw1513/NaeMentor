package com.min.naementor.spring.model.review;

import java.util.List;

import com.min.naementor.dtos.MemberScheduleDto;
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
	 * 
	 * @param dto
	 * @return
	 */
	public boolean insertReview(ReviewDto dto);
}
