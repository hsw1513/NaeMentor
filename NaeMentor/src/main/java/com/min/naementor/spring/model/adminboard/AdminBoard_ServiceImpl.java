package com.min.naementor.spring.model.adminboard;

import java.util.Map;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

public class AdminBoard_ServiceImpl implements AdminBoard_IService {

	@Override
	public NaememberDto userBasicInfo(String auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfileDto userDetail(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindingMentorDto SearchRC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReport(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NaememberDto searchByeU() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeStatus(NaememberDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mentorPromotion(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean promotionDate(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NaememberDto searchApplier() {
		// TODO Auto-generated method stub
		return null;
	}

}
