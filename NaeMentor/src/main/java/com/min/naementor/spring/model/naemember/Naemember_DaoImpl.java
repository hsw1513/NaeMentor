package com.min.naementor.spring.model.naemember;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Repository
public class Naemember_DaoImpl implements Naemember_IDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private final String NS ="com.min.naementor.naemember.";
	
	
	@Override
	public boolean signUp(NaememberDto dto) { // 암호화 회원가입
		String encPassword = passwordEncoder.encode(dto.getPassword()); // dto에 있는 패스워드를 암호화
		dto.setPassword(encPassword);
		int cnt = sqlSession.insert(NS+"signUp", dto);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean idDupleChk(String email) { // 아이디 중복체크
		int cnt = sqlSession.selectOne(NS+"idDupleChk", email); // 중복이면 true
		return (cnt>0)?true:false;
	}

	@Override
	public boolean insertProFile(ProfileDto dto) { // 프로필 입력
		int cnt = sqlSession.insert(NS+"insertProFile", dto);
		return (cnt>0)?true:false;
	}
	
	@Override
	public boolean cancelSignUp(String memberseq) { // 회원가입 취소
		int cnt = sqlSession.delete(NS+"cancelSignUp", memberseq);
		return (cnt>0)?true:false;
	}
	
	@Override
	public boolean nickDupleChk(String nickname) { // 닉네임 중복체크
		int cnt = sqlSession.selectOne(NS+"nickDupleChk", nickname);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean PfileUpload(AttachFileDto dto) { //프로필 파일 업로드
		int cnt = sqlSession.insert(NS+"PfileUpload", dto);
		return (cnt>0)?true:false;
	}

	@Override
	public NaememberDto encLogin(String email) { // 로그인
		return sqlSession.selectOne(NS+"encLogin", email);
	}

	@Override
	public boolean loginCount(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"loginCount", map);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean wakeUp(String memberseq) {
		int cnt = sqlSession.update(NS+"wakeUp", memberseq);
		return (cnt>0)?true:false;
	}

	@Override
	public String searchId(NaememberDto dto) {
		return sqlSession.selectOne(NS+"searchId", dto);
	}

	@Override
	public String searchPassword(NaememberDto dto) {
		return sqlSession.selectOne(NS+"searchPassword", dto);
	}

	@Override
	public boolean changePassword(NaememberDto dto) {
		String encPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encPassword);
		int cnt = sqlSession.update(NS+"changePassword", dto);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean logoutTime(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"logoutTime", map);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean initLoginCount(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"initLoginCount", map);
		return (cnt>0)?true:false;
	}

	@Override
	public int searchLoginCnt(Map<String, String> map) {
		int cnt = sqlSession.selectOne(NS+"searchLoginCnt", map);
		return cnt;
	}

	@Override
	public boolean goToBed() {
		int cnt = sqlSession.update(NS+"goToBed");
		return (cnt>0)?true:false;
	}

	@Override
	public boolean wakeUpStop() {
		int cnt = sqlSession.update(NS+"wakeUpStop");
		return (cnt>0)?true:false;
	}

	

}
