package com.min.naementor.spring.model.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.MemberScheduleDto;
import com.min.naementor.dtos.ReviewDto;
@Repository
public class Review_DaoImpl implements Review_IDao {
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.review.";
	
	@Override
	public List<ReviewDto> searchMStar(String mentorseq) {
		return session.selectList(NS+"searchMStar", mentorseq);
	}

	@Override
	public List<ReviewDto> denyMSearch(String menteeseq) {
		return session.selectList(NS+"denyMSearch", menteeseq);
	}

	@Override
	public boolean insertReview(ReviewDto dto) {
		return session.insert(NS+"insertReview", dto)>0?true:false;
	}

}
