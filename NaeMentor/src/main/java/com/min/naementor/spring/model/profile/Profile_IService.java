package com.min.naementor.spring.model.profile;

import java.util.Map;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface Profile_IService {
	/**
	 * 프로필 정보 조회
	 * @param memberseq
	 * @return
	 */
	public NaememberDto encLogin(String memberseq);
	/**
	 * 회원 탈퇴
	 * @param memberseq
	 * @return
	 */
	public boolean applyBye(String memberseq);
	/**
	 * 프로필 입력
	 * @param dto
	 * @return
	 */
	public boolean insertProfile(ProfileDto dto);
	/**
	 * 파일 입력
	 * @param dto
	 * @return
	 */
	public boolean insertFile(AttachFileDto dto);
	/**
	 * 권한 변경
	 * @param memberseq
	 * @return
	 */
	public boolean updateAuth(String memberseq);
	
	/**
	 * 프로필 정보 수정
	 * @param memberseq, nickname
	 * @return
	 */
	public boolean changeNickName(NaememberDto dto);
	
	/**
	 * 프로필 정보 수정
	 * @param memberseq, introduce
	 * @return
	 */
	public boolean changeIntro(NaememberDto dto);
	
	/**
	 * 프로필 정보 수정(휴대폰 번호)
	 * @param memberseq, phone
	 * @return
	 */
	public boolean changePhone(NaememberDto dto);
	/**
	 * 권한 변경
	 * @param map(tomentor/tomentee/memberseq)
	 * @return boolean(true:변경성공)
	 */
	public boolean changeAuth(Map<String,String> map);
	
	
}
