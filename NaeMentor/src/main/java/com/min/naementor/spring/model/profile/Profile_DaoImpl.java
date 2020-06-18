package com.min.naementor.spring.model.profile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Repository
public class Profile_DaoImpl implements Profile_IDao{
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.profile.";
	@Override
	public NaememberDto encLogin(String memberseq) {
		return session.selectOne(NS+"encLogin", memberseq);
	}
	@Override
	public boolean applyBye(String memberseq) {
		return session.update(NS+"applyBye", memberseq)>0?true:false;
	}
	@Override
	public boolean insertProfile(ProfileDto dto) {
		return session.insert(NS+"insertProfile", dto)>0?true:false;
	}
	@Override
	public boolean insertFile(AttachFileDto dto) {
		return session.update(NS+"insertFile", dto)>0?true:false;
	}
	@Override
	public boolean updateFilechk(String memberseq) {
		return session.update(NS+"updateFilechk", memberseq)>0?true:false;
	}
	@Override
	public boolean updateAuth(String memberseq) {
		return session.update(NS+"updateAuth", memberseq)>0?true:false;
	}
	@Override
	public boolean changeNickName(NaememberDto dto) {
		int cnt = session.update(NS+"changeNickName", dto);
		return (cnt>0)?true:false;
	}
	@Override
	public boolean changeIntro(NaememberDto dto) {
		int cnt = session.update(NS+"changeIntro", dto);
		return (cnt>0)?true:false;
	}
	@Override
	public boolean changePhone(NaememberDto dto) {
		int cnt = session.update(NS+"changePhone", dto);
		return (cnt>0)?true:false;
	}
}
