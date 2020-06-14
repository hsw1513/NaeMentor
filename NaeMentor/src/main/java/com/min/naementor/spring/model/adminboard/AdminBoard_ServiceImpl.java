package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Service
public class AdminBoard_ServiceImpl implements AdminBoard_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminBoard_IDao dao;
	
	@Override
	public List<NaememberDto> userBasicInfo() {
		return dao.userBasicInfo();
	}

	@Override
	public ProfileDto userDetail(String memberseq) {
		return dao.userDetail(memberseq);
	}

	@Override
	public List<FindingMentorDto> SearchRC() {
		return dao.SearchRC();
	}

	@Override
	public boolean deleteReport(Map<String, String> map) {
		return dao.deleteReport(map);
	}

	@Override
	public List<NaememberDto> searchByeU() {
		return dao.searchByeU();
	}

	@Override
	public boolean changeStatus(Map<String, String> map) {
		return dao.changeStatus(map);
	}

	@Override
	public boolean mentorPromotion(Map<String, String> map) {
		return dao.mentorPromotion(map);
	}

	@Override
	public boolean promotionDate(Map<String, String> map) {
		return dao.promotionDate(map);
	}

	@Override
	public List<NaememberDto> searchApplier() {
		return dao.searchApplier();
	}

}
