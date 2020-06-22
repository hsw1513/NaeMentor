package com.min.naementor.spring.model.profile;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;
@Service
public class Profile_ServiceImpl implements Profile_IService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Profile_IDao dao;
	
	/**
	 * 프로필 정보 조회
	 * @param memberseq
	 * @return 프로필 정보
	 */
	@Override
	public NaememberDto encLogin(String memberseq) {
		log.info("Profile_ServiceImpl encLogin:{}",memberseq);
		return dao.encLogin(memberseq);
	}
	
	/**
	 * 회원 탈퇴
	 * @param memberseq
	 * @return 탈퇴 성공 여부
	 */
	@Override
	public boolean applyBye(String memberseq) {
		log.info("Profile_ServiceImpl applyBye:{}",memberseq);
		return dao.applyBye(memberseq);
	}
	
	/**
	 * 프로필 입력
	 * @param dto
	 * @return 입력 성공 여부
	 */
	@Override
	public boolean insertProfile(ProfileDto dto) {
		log.info("Profile_ServiceImpl insertProfile:{}",dto);
		return dao.insertProfile(dto);
	}
	
	/**
	 * 파일 입력
	 * @param dto
	 * @return 입력 성공 여부
	 */
	@Override
	public boolean insertFile(AttachFileDto dto) {
		log.info("Profile_ServiceImpl insertFile:{}",dto);
		if(dao.insertFile(dto)) {
			return dao.updateFilechk(dto.getMemberseq());
		}else {
			return false;
		}
	}
	
	/**
	 * 권한 변경
	 * @param memberseq
	 * @return 권한변경 성공 여부
	 */
	@Override
	public boolean updateAuth(String memberseq) {
		log.info("Profile_ServiceImpl updateAuth:{}",memberseq);
		return dao.updateAuth(memberseq);
	}
	
	/**
	 * 프로필 정보 수정(닉네임)
	 * @param memberseq, nickname
	 * @return 정보수정 성공 여부
	 */
	@Override
	public boolean changeNickName(NaememberDto dto) {
		log.info("Profile_ServiceImpl changeNickName:{}",dto);
		return dao.changeNickName(dto);
	}
	
	/**
	 * 프로필 정보 수정(자기소개)
	 * @param memberseq, introduce
	 * @return 수정 성공 여부
	 */
	@Override
	public boolean changeIntro(NaememberDto dto) {
		log.info("Profile_ServiceImpl changeIntro:{}",dto);
		return dao.changeIntro(dto);
	}
	
	/**
	 * 프로필 정보 수정(휴대폰 번호)
	 * @param memberseq, phone
	 * @return 수정 성공 여부
	 */
	@Override
	public boolean changePhone(NaememberDto dto) {
		log.info("Profile_ServiceImpl changePhone:{}",dto);
		return dao.changePhone(dto);
	}
	
	/**
	 * 권한 변경
	 * @param map(tomentor/tomentee/memberseq)
	 * @return boolean(true:변경성공)
	 */
	@Override
	public boolean changeAuth(Map<String, String> map) {
		log.info("Profile_ServiceImpl changeAuth:{}",map);
		return dao.changeAuth(map);
	}
	
}
