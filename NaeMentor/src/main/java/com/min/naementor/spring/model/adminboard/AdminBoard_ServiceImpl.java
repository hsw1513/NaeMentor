package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Service
public class AdminBoard_ServiceImpl implements AdminBoard_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private AdminBoard_IDao dao;
	
	@Override
	public List<NaememberDto> userBasicInfo() {
		return dao.userBasicInfo();
	}

	@Override
	public ProfileDto userDetail(Map<String, String> map) {
		return dao.userDetail(map);
	}

	@Override
	public FindingMentorDto SearchRC() {
		return dao.SearchRC();
	}

	@Override
	public boolean deleteReport(Map<String, String> map) {
		return dao.deleteReport(map);
	}

	@Override
	public NaememberDto searchByeU() {
		return dao.searchByeU();
	}

	@Override
	public boolean changeStatus(NaememberDto dto) {
		return dao.changeStatus(dto);
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
	public NaememberDto searchApplier() {
		return dao.searchApplier();
	}

}
