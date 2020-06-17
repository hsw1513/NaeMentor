package com.min.naementor.spring.model.naemember;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface Naemember_IDao {

	/**
	 * 회원가입(signUp)
	 * @param 회원가입 정보
	 * @return 회원등록 성공 여부(true 성공)
	 */
	public boolean signUp(NaememberDto dto);
	
	/**
	 * 아이디 중복검사(idDupleChk)
	 * @param 중복확인 값(이메일)
	 * @return 사용가능 여부(true 사용가능)
	 */
	public boolean idDupleChk(String email);
	
	/**
	 * 프로필 입력(insertProFile)
	 * @param 프로필 입력 정보
	 * @return 프로필 입력 성공여부(true 성공)
	 */
	public boolean insertProFile(ProfileDto dto);
	
	/**
	 * 회원가입취소(cancelSignUp)
	 * @param 회원번호
	 * @return 회원가입 취소 여부(true 성공)
	 */
	public boolean cancelSignUp(String memberseq);
	
	/**
	 * 닉네임 중복검사(nickDupleChk)
	 * @param 중복확인 값(닉네임)
	 * @return 사용가능 여부(true 사용가능)
	 */
	public boolean nickDupleChk(String nickname);
	
	/**
	 * 프로필 파일업로드(PfileUpload)
	 * @param 파일업로드 정보
	 * @return 파일업로드 성공여부(true 성공)
	 */
	public boolean PfileUpload(AttachFileDto dto);
	
	/**
	 * 암호화로그인(encLogin)
	 * @param 로그인 정보 값(email)
	 * @return 로그인 한 회원의 정보 값
	 */
	public NaememberDto encLogin(String email);
	
	/**
	 * 로그인 실패 시 로그인 시도 카운트 증가
	 * @param 로그인 정보 값(email)
	 * @return 로그인 시도 횟수 증가 성공여부
	 */
	public boolean loginCount(Map<String, String> map);

	/**
	 * 로그인 성공시 카운트 초기화(loginCount)
	 * @param 로그인 정보 값(email)
	 * @return 로그인 시도 횟수 초기화 성공여부
	 */
	public boolean initLoginCount(Map<String, String> map);

	/**
	 * 로그인 시도 횟수 조회
	 * @param 로그인 정보 값(email)
	 * @return 로그인 시도 횟수
	 */
	public int searchLoginCnt(Map<String, String> map);
	
	
	
	/**
	 * 로그인시 시간 기록
	 * @param 아이디(email)
	 * @return 시간기록 성공 여부(성공시 true)
	 */
	public boolean logoutTime(Map<String, String> map);
	
	/**
	 * 휴면회원(R)이 로그인 시 상태 변경(A)
	 * @param memberseq
	 * @return 휴면회원 상태 변경(A)
	 */
	public boolean wakeUp(String memberseq);
	
	/**
	 * 아이디 찾기
	 * @param 휴대전화 번호(phone), 생년월일(birthday)
	 * @return 아이디 정보(email)
	 */
	public String searchId(NaememberDto dto); 
	
	/**
	 * 비밀번호 찾기
	 * @param 이메일(email), 생년월일(birthday)
	 * @return 보낼 이메일 주소(email)
	 */
	public String searchPassword(NaememberDto dto); 
	
	/**
	 * 비밀번호 변경하기
	 * @param 이메일(email)
	 * @return 비밀번호 변경
	 */
	public boolean changePassword(NaememberDto dto);
	
	
}