package com.min.naementor.spring.model.adminboard;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.NaememberDto;
import com.min.naementor.dtos.ProfileDto;

@Repository
public class AdminBoard_DaoImpl implements AdminBoard_IDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.naementor.naemember.admin.";
	
	// 회원 기본 정보 조회
	@Override
	public List<NaememberDto> userBasicInfo() {
		return sqlSession.selectList(NS+"userBasicInfo");
	}

	// 회원정보 조회 상세
	@Override
	public ProfileDto userDetail(Map<String, String> map) {
		return sqlSession.selectOne(NS+"userDetail", map);
	}

	// 신고게시글 조회
	@Override
	public FindingMentorDto SearchRC() {
		return sqlSession.selectOne(NS+"SearchRC");
	}

	// 신고게시글 삭제
	@Override
	public boolean deleteReport(Map<String, String> map) {
		int cnt = sqlSession.delete(NS+"deleteReport", map);
		return (cnt>0)?true:false;
	}

	// 탈퇴신청 회원 조회
	@Override
	public NaememberDto searchByeU() {
		return sqlSession.selectOne(NS+"searchByeU");
	}
	
	// 회원 계정 상태 변경
	@Override
	public boolean changeStatus(NaememberDto dto) {
		int cnt = sqlSession.update(NS+"changeStatus", dto);
		return (cnt>0)?true:false;
	}

	// 멘토승인시 권한 변경
	@Override
	public boolean mentorPromotion(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"mentorPromotion", map);
		return (cnt>0)?true:false;
	}
	
	// 멘토 승급시 승급일 기록
	@Override
	public boolean promotionDate(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"promotionDate", map);
		return (cnt>0)?true:false;
	}

	// 멘토신청자 조회
	@Override
	public NaememberDto searchApplier() {
		return sqlSession.selectOne(NS+"searchApplier");
	}

}
