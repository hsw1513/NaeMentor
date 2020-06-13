package com.min.naementor.spring.model.profile;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public interface Profile_IDao {
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
	 * 파일체크 변경
	 * @param memberseq
	 * @return
	 */
	public boolean updateFilechk(String memberseq);
	/**
	 * 권한 변경
	 * @param memberseq
	 * @return
	 */
	public boolean updateAuth(String memberseq);
}
