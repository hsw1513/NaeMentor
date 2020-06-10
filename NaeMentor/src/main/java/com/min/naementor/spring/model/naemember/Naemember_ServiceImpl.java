package com.min.naementor.spring.model.naemember;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Service
public class Naemember_ServiceImpl implements Naemember_IService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Naemember_IDao dao;
	
	/**
	 * <h2>회원가입</h2>
	 * @param 이메일, 비밀번호, 닉네임, 자기소개, 전화번호, 생년월일, 성별
	 * @return 데이터 입력 성공시 true, 실패시 false
	 */
	@Override
	public boolean signUp(NaememberDto dto) {
		log.info("signUp 회원가입, \n {}", dto);
		return dao.signUp(dto);
	}

	/**
	 * <h2>아이디 중복체크</h2>
	 * @param 이메일
	 * @return 아이디 중복시 true, 중복아닐시 false
	 */
	@Override
	public boolean idDupleChk(String email) {
		log.info("idDupleChk 아이디 중복체크, {}", email);
		return dao.idDupleChk(email);
	}
	
	/**
	 * <h2>프로필 입력</h2>
	 * @param 사진, 학교, 전공, 경력, 증명서, 전문분야
	 * @return 입력 성공시 true, 입력 실패시 false
	 */
	@Override
	public boolean insertProFile(ProfileDto dto) {
		log.info("insertProFile 프로필 입력, {}", dto);
		return dao.insertProFile(dto);
	}

	/**
	 * <h2>회원기입 취소</h2>
	 * @param 회원번호
	 * @return 취소 성공시 true, 취소 실패시 false
	 */
	@Override
	public boolean cancelSignUp(String memberseq) {
		log.info("cancelSignUp 회원가입 취소, {}", memberseq);
		return dao.cancelSignUp(memberseq);
	}


	/**
	 * <h2>닉네임 중복체크</h2>
	 * @param 닉네임
	 * @return 닉네임 중복시 true, 중복아닐시 false
	 */
	@Override
	public boolean nickDupleChk(String nickname) {
		log.info("nickDupleChk 닉네임 중복확인, {}", nickname);
		return dao.nickDupleChk(nickname);
	}

	/**
	 * <h2>프로필 파일업로드</h2>
	 * @param 일반파일명, UUID파일명, 파일경로
	 * @return 업로드 성공시 true, 실패시 false
	 */
	@Override
	public boolean PfileUpload(AttachFileDto dto) {
		log.info("PfileUpload 프로필 파일업로드, {}", dto);
		return dao.PfileUpload(dto);
	}

	/**
	 * <h2>암호화 로그인</h2>
	 * @param 이메일
	 * @return 로그인정보들
	 */
	@Override
	public NaememberDto encLogin(String email) {
		log.info("encLogin 암호화로그인, {}", email);
		return dao.encLogin(email);
	}

	/**
	 * <h2>로그인 카운트 증가</h2>
	 * @param 이메일
	 * @return 로그인 실패시 카운트증가 true, 성공시 false
	 */
	@Override
	public boolean loginCount(Map<String, Object> map) {
		log.info("loginCount 로그인 카운트 증가, {}", map);
		return dao.loginCount(map);
	}

	

}
