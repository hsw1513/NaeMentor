package com.min.naementor.spring.model.review;

import java.util.List;

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
	public boolean insertReview(ReviewDto dto) {
		log.info("insertReview{}",dto);
		return dao.insertReview(dto);
	}

}
