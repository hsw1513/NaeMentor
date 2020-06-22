package com.min.naementor.spring.model.profile;

import java.util.Map;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface Profile_IDao {
	/**
	 * 프로필 정보 조회
	 * @param memberseq
	 * @return 프로필 정보
	 */
	public NaememberDto encLogin(String memberseq);
	/**
	 * 회원 탈퇴
	 * @param memberseq
	 * @return 탈퇴 성공 여부
	 */
	public boolean applyBye(String memberseq);
	/**
	 * 프로필 입력
	 * @param dto
	 * @return 입력 성공 여부
	 */
	public boolean insertProfile(ProfileDto dto);
	/**
	 * 파일 입력
	 * @param dto
	 * @return 입력 성공 여부
	 */
	public boolean insertFile(AttachFileDto dto);
	/**
	 * 파일체크 변경
	 * @param memberseq
	 * @return 변경 성공 여부
	 */
	public boolean updateFilechk(String memberseq);
	/**
	 * 권한 변경
	 * @param memberseq
	 * @return 권한변경 성공 여부
	 */
	public boolean updateAuth(String memberseq);
	
	/**
	 * 프로필 정보 수정(닉네임)
	 * @param memberseq, nickname
	 * @return 정보수정 성공 여부
	 */
	public boolean changeNickName(NaememberDto dto);
	
	/**
	 * 프로필 정보 수정(자기소개)
	 * @param memberseq, introduce
	 * @return 수정 성공 여부
	 */
	public boolean changeIntro(NaememberDto dto);
	
	/**
	 * 프로필 정보 수정(휴대폰 번호)
	 * @param memberseq, phone
	 * @return 수정 성공 여부
	 */
	public boolean changePhone(NaememberDto dto);
	/**
	 * 권한 변경
	 * @param map(tomentor/tomentee/memberseq)
	 * @return boolean(true:변경성공)
	 */
	public boolean changeAuth(Map<String,String> map);
}
