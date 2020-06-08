package com.min.naementor.spring.model.findingMentor;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;

@Service
public class FindingMentor_ServiceImpl implements FindingMentor_IService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FindingMentor_IDao dao;
	
	@Override
	public FindingMentorDto detailContent(Map<String, String> map) {
		log.info("detailContent {}",map);
		return dao.detailContent(map);
	}

	@Override
	public boolean applyMentor(Map<String, String> map) {
		log.info("applyMentor {}",map);
		if(dao.applyMentorChk(map)) {
			return dao.applyMentor(map);	
		}else {
			return false;
		}
	}

	@Override
	public boolean reportCntUpdate(Map<String, String> map) {
		log.info("reportCntUpdate {}",map);
		if(dao.reportContentChk(map)) {
		   if(dao.reportUserUpdate(map)&&dao.reportCntUpdate(map)) {
			   return true;
		   }else {
			   return false;
		   }
		}else {
			return false;
		}
	}

	@Override
	public boolean insertContent(FindingMentorDto dto) {
		log.info("insertContent {}",dto);
		return dao.insertContent(dto);
	}

	@Override
	public FindingMentorDto modifyContentSelect(Map<String, String> map) {
		log.info("modifyContentSelect {}",map);
		return dao.modifyContentSelect(map);
	}

	@Override
	public boolean modifyContent(FindingMentorDto dto) {
		log.info("modifyContent {}",dto);
		return dao.modifyContent(dto);
	}

	@Override
	public boolean deleteContent(Map<String, String> map) {
		log.info("deleteContent {}",map);
		return dao.deleteContent(map);
	}

	@Override
	public boolean multidelContent(Map<String, String[]> map) {
		log.info("multidelContent {}",map);
		return dao.multidelContent(map);
	}

	@Override
	public boolean matching(MatchingDto dto) {
		log.info("matching {}",dto);
		return dao.matching(dto);
	}

	@Override
	public List<FindingMentorDto> selectAll() {
		log.info("selectAll {}",new Date());
		return dao.selectAll();
	}

}
