package com.min.naementor.spring.model.findingMentor;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
@Repository
public class FindingMentor_DaoImpl implements FindingMentor_IDao{
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.findingmentor.";
	
	@Override
	public FindingMentorDto detailContent(Map<String, String> map) {
		return session.selectOne(NS+"detailContent", map);
	}

	@Override
	public boolean applyMentor(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean applyMentorChk(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reportCntUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reportUserUpdate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reportContentChk(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertContent(FindingMentorDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FindingMentorDto modifyContentSelect(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyContent(FindingMentorDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContent(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean multidelContent(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matching(MatchingDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FindingMentorDto> selectAll() {
		return session.selectList(NS+"selectAll");
	}

}
