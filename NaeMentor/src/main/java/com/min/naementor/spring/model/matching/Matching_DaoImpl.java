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
	public List<MatchingDto> chkMatching(String boardseq) {
		return session.selectList(NS+"chkMatching", boardseq);
	}
	
}
