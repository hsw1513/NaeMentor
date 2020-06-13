package com.min.naementor.spring.model.report;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.ReportDto;

@Service
public class Report_ServiceImpl implements Report_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Report_IDao dao;

	@Override
	public List<ReportDto> searchReportU(Map<String, String> map) {
		return dao.searchReportU(map);
	}

	@Override
	public boolean addReportCnt(Map<String, String> map) {
		return dao.addReportCnt(map);
	}

}
