package com.min.naementor.spring.model.profile;

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
	@Override
	public NaememberDto encLogin(String memberseq) {
		log.info("Profile_ServiceImpl encLogin:{}",memberseq);
		return dao.encLogin(memberseq);
	}
	@Override
	public boolean applyBye(String memberseq) {
		log.info("Profile_ServiceImpl applyBye:{}",memberseq);
		return dao.applyBye(memberseq);
	}
	@Override
	public boolean insertProfile(ProfileDto dto) {
		log.info("Profile_ServiceImpl insertProfile:{}",dto);
		return dao.insertProfile(dto);
	}
	@Override
	public boolean insertFile(AttachFileDto dto) {
		log.info("Profile_ServiceImpl insertFile:{}",dto);
		if(dao.insertFile(dto)) {
			return dao.updateFilechk(dto.getMemberseq());
		}else {
			return false;
		}
	}
	@Override
	public boolean updateAuth(String memberseq) {
		log.info("Profile_ServiceImpl updateAuth:{}",memberseq);
		return dao.updateAuth(memberseq);
	}
	@Override
	public boolean changeNickName(NaememberDto dto) {
		log.info("Profile_ServiceImpl changeNickName:{}",dto);
		return dao.changeNickName(dto);
	}
	@Override
	public boolean changeIntro(NaememberDto dto) {
		log.info("Profile_ServiceImpl changeIntro:{}",dto);
		return dao.changeIntro(dto);
	}
	@Override
	public boolean changePhone(NaememberDto dto) {
		log.info("Profile_ServiceImpl changePhone:{}",dto);
		return dao.changePhone(dto);
	}
	
}
