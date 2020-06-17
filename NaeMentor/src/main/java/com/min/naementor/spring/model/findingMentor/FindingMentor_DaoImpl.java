package com.min.naementor.spring.model.findingMentor;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;
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
		return session.update(NS+"applyMentor", map)>0?true:false;
	}

	@Override
	public boolean applyMentorChk(Map<String, String> map) {
		int i = Integer.parseInt(session.selectOne(NS+"applyMentorChk", map));
		return i==0?true:false;
	}

	@Override
	public boolean reportCntUpdate(Map<String, String> map) {
		return session.update(NS+"reportCntUpdate", map)>0?true:false;
	}

	@Override
	public boolean reportUserUpdate(Map<String, String> map) {
		return session.update(NS+"reportUserUpdate", map)>0?true:false;
	}

	@Override
	public boolean reportContentChk(Map<String, String> map) {
		String val = session.selectOne(NS+"reportContentChk", map);
		return val.equals("0");
	}

	@Override
	public boolean insertContent(FindingMentorDto dto) {
		return session.insert(NS+"insertContent", dto)>0?true:false;
	}

	@Override
	public FindingMentorDto modifyContentSelect(Map<String, String> map) {
		return session.selectOne(NS+"modifyContentSelect", map);
	}

	@Override
	public boolean modifyContent(FindingMentorDto dto) {
		return session.update(NS+"modifyContent", dto)>0?true:false;
	}

	@Override
	public boolean deleteContent(Map<String, String> map) {
		return session.update(NS+"deleteContent", map)>0?true:false;
	}

	@Override
	public boolean multidelContent(Map<String, String[]> map) {
		return session.update(NS+"multidelContent", map)>0?true:false;
	}

	@Override
	public boolean matching(MatchingDto dto) {
		return session.insert(NS+"matching", dto)>0?true:false;
	}

	@Override
	public List<FindingMentorDto> selectAll() {
		return session.selectList(NS+"selectAll");
	}

	@Override
	public List<NaememberDto> chkUser(Map<String, String[]> map) {
		return session.selectList(NS+"chkUser", map);
	}

	@Override
	public boolean updateMatching(String boardseq) {
		return session.update(NS+"updateMatching", boardseq)>0?true:false;
	}

	@Override
	public List<FindingMentorDto> chkMatching(Map<String,String> map) {
		return session.selectList(NS+"chkMatching", map);
	}

	@Override
	public List<FindingMentorDto> chkComplete(Map<String,String> map) {
		return session.selectList(NS+"chkComplete", map);
	}

	@Override
	public boolean updateComplete(String boardseq) {
		return session.update(NS+"updateComplete", boardseq)>0?true:false;
	}

	@Override
	public boolean updateNoMatching(String boardseq) {
		return session.update(NS+"updateNoMatching", boardseq)>0?true:false;
	}

}
