package com.min.naementor.spring.model.matching;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.MatchingDto;
@Repository
public class Matching_DaoImpl implements Matching_IDao{
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.matching.";
	@Override
	public MatchingDto chkMatching(String boardseq) {
		return session.selectOne(NS+"chkMatching", boardseq);
	}
	@Override
	public boolean chkMatchingCount(String boardseq) {
		int i = session.selectOne(boardseq);
		return i>0?true:false;
	}
	
}
