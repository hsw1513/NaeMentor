package com.min.naementor.spring.model.report;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.ReportDto;

@Repository
public class Report_DaoImpl implements Report_IDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS ="com.min.naementor.report.";
	
	
	@Override
	public List<ReportDto> searchReportU() {
		return sqlSession.selectList(NS+"searchReportU");
	}

	@Override
	public boolean addReportCnt(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"addReportCnt", map);
		return (cnt>0)?true:false;
	}

	@Override
	public boolean changeSingoChk(Map<String, String> map) {
		int cnt = sqlSession.update(NS+"changeSingoChk", map);
		return (cnt>0)?true:false;
	}

}
