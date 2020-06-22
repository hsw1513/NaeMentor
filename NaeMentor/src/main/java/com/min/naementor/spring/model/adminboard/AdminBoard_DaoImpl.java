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
	private final String NS2 = "com.min.naementor.report.";
	
	// 회원 기본 정보 조회
	@Override
	public List<NaememberDto> userBasicInfo() {
		return sqlSession.selectList(NS+"userBasicInfo");
	}

	// 회원정보 조회 상세
	@Override
	public ProfileDto userDetail(String memberseq) {
		return sqlSession.selectOne(NS+"userDetail", memberseq);
	}

	// 신고게시글 조회
	@Override
	public List<FindingMentorDto> SearchRC() {
		return sqlSession.selectList(NS+"SearchRC");
	}

	// 신고게시글 삭제
	@Override
	public boolean deleteReportAuto() {
		int cnt = sqlSession.delete(NS+"deleteReportAuto");
		return (cnt>0)?true:false;
	}

	// 탈퇴신청 회원 조회
	@Override
	public List<NaememberDto> searchByeU() {
		return sqlSession.selectList(NS+"searchByeU");
	}
	
	// 회원 계정 상태 변경
	@Override
	public boolean changeStatusBye() {
		int cnt = sqlSession.update(NS+"changeStatusBye");
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
	public List<NaememberDto> searchApplier() {
		return sqlSession.selectList(NS+"searchApplier");
	}

	// 멘토신청 거절시 FILECHK 상태 변경
	@Override
	public boolean mentorCancel(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"mentorCancel", map);
		return (cnt>0)?true:false;
	}

	@Override
	public String denyId(Map<String, String> map) {
		return sqlSession.selectOne(NS+"denyId", map);
	}

	@Override
	public String searchReportCnt(Map<String, String> map) {
		return sqlSession.selectOne(NS2+"searchReportCnt", map);
	}

	@Override
	public boolean tierPromotion(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"tierPromotion", map);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean deleteReport(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"deleteReport", map);
		return (cnt>0)?true:false;
	}

	@Override
	public NaememberDto personalInfo(Map<String, String> map) {
		return sqlSession.selectOne(NS+"personalInfo", map);
	}

	@Override
	public boolean authorChk(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"authorChk", map);
		return (cnt>0)? true:false;
	}

}
