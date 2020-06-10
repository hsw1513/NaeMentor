package com.min.naementor.spring.model.review;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.MemberScheduleDto;
import com.min.naementor.dtos.ReviewDto;
@Service
public class Review_ServiceImpl implements Review_IService{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Review_IDao dao;
	
	@Override
	public List<ReviewDto> searchMStar(String mentorseq) {
		log.info("searchMStar{}",mentorseq);
		return dao.searchMStar(mentorseq);
	}

	@Override
	public List<ReviewDto> denyMSearch(String menteeseq) {
		log.info("denyMSearch{}",menteeseq);
		return dao.denyMSearch(menteeseq);
	}

	@Override
	public boolean chkReviewMentor(String boardseq) {
		log.info("chkReviewMentor{}",boardseq);
		return dao.chkReviewMentor(boardseq);
	}

	@Override
	public boolean insertReviewMentor(ReviewDto dto) {
		log.info("insertReviewMentor{}",dto);
		return dao.insertReviewMentor(dto);
	}

	@Override
	public boolean chkReviewMentee(String boardseq) {
		log.info("chkReviewMentee{}",boardseq);
		return dao.chkReviewMentee(boardseq);
	}

	@Override
	public boolean insertReviewMentee(ReviewDto dto) {
		log.info("insertReviewMentee{}",dto);
		return dao.insertReviewMentee(dto);
	}

	@Override
	public boolean updateMenteeAccStar(Map<String, String> map) {
		log.info("updateMenteeAccStar{}",map);
		return dao.updateMenteeAccStar(map);
	}

	@Override
	public boolean updateMentoAccStar(Map<String, String> map) {
		log.info("updateMentoAccStar{}",map);
		return dao.updateMentoAccStar(map);
	}


}
