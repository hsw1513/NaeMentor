package com.min.naementor.spring.model.review;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public boolean chkReviewMentor(String boardseq) {
		int i = session.selectOne(NS+"chkReviewMentor", boardseq);
		return (i==0)?true:false;
	}

	@Override
	public boolean insertReviewMentor(ReviewDto dto) {
		return session.insert(NS+"insertReviewMentor", dto)>0?true:false;
	}

	@Override
	public boolean chkReviewMentee(String boardseq) {
		int i = session.selectOne(NS+"chkReviewMentee", boardseq);
		return (i==0)?true:false;
	}

	@Override
	public boolean insertReviewMentee(ReviewDto dto) {
		return session.insert(NS+"insertReviewMentee", dto)>0?true:false;
	}

	@Override
	public boolean updateMenteeAccStar(Map<String, String> map) {
		return session.update(NS+"updateMenteeAccStar", map)>0?true:false;
	}

	@Override
	public boolean updateMentoAccStar(Map<String, String> map) {
		return session.update(NS+"updateMentoAccStar", map)>0?true:false;
	}

	@Override
	public boolean chkReviewCount(String boardseq) {
		int i = session.selectOne(NS+"chkReviewCount", boardseq);
		return (i==2)?true:false;
	}


}
