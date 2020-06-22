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
	
	@Override
	public boolean signUp(NaememberDto dto) {
		log.info("signUp 회원가입, \n {}", dto);
		return dao.signUp(dto);
	}

	@Override
	public boolean idDupleChk(String email) {
		log.info("idDupleChk 아이디 중복체크, {}", email);
		return dao.idDupleChk(email);
	}
	
	@Override
	public boolean insertProFile(ProfileDto dto) {
		log.info("insertProFile 프로필 입력, {}", dto);
		return dao.insertProFile(dto);
	}

	@Override
	public boolean cancelSignUp(String memberseq) {
		log.info("cancelSignUp 회원가입 취소, {}", memberseq);
		return dao.cancelSignUp(memberseq);
	}


	@Override
	public boolean nickDupleChk(String nickname) {
		log.info("nickDupleChk 닉네임 중복확인, {}", nickname);
		return dao.nickDupleChk(nickname);
	}

	@Override
	public boolean PfileUpload(AttachFileDto dto) {
		log.info("PfileUpload 프로필 파일업로드, {}", dto);
		return dao.PfileUpload(dto);
	}

	@Override
	public NaememberDto encLogin(String email) {
		log.info("encLogin 암호화로그인, {}", email);
		return dao.encLogin(email);
	}

	@Override
	public boolean loginCount(Map<String, String> map) {
		log.info("loginCount 로그인 카운트 증가, {}", map);
		return dao.loginCount(map);
	}

	@Override
	public boolean wakeUp(String memberseq) {
		log.info("loginCount 회원상태 변경, {}", memberseq);
		return dao.wakeUp(memberseq);
	}

	@Override
	public String searchId(NaememberDto dto) {
		log.info("searchId 아이디 찾기, {}", dto);
		return dao.searchId(dto);
	}

	@Override
	public String searchPassword(NaememberDto dto) {
		log.info("searchPassword 아이디 찾기, {}", dto);
		return dao.searchPassword(dto);
	}

	@Override
	public boolean changePassword(NaememberDto dto) {
		log.info("searchPassword 비밀번호 변경, {}", dto);
		return dao.changePassword(dto);
	}
	
	@Override
	public boolean logoutTime(Map<String, String> map) {
		log.info("logoutTime 로그아웃 시간 기록, {}", map);
		return dao.logoutTime(map);
	}

	@Override
	public boolean initLoginCount(Map<String, String> map) {
		log.info("initLoginCount 로그인 시도 카운트 초기화, {}", map);
		return dao.initLoginCount(map);
	}

	@Override
	public int searchLoginCnt(Map<String, String> map) {
		log.info("searchLoginCnt 로그인 시도 횟수 조회, {}", map);
		return dao.searchLoginCnt(map);
	}

	@Override
	public boolean goToBed() {
		log.info("goToBed 6개월 접속 안한 회원 자동 휴면 전환");
		return dao.goToBed();
	}
	
	@Override
	public boolean wakeUpStop() {
		log.info("wakeUpStop 정지회원 한달 후 자동 액티브 전환");
		return dao.wakeUpStop();
	}

	

}
