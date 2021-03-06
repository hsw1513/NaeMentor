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
import com.min.naementor.dtos.NaememberDto;

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
		if(dao.updateMatching(dto.getBoardseq())) {
			return dao.matching(dto);
		}else {
			return false;
		}
	}

	@Override
	public List<FindingMentorDto> selectAll() {
		log.info("selectAll {}",new Date());
		return dao.selectAll();
	}

	@Override
	public List<NaememberDto> chkUser(Map<String, String[]> map) {
		log.info("chkMentor {}",map);
		return dao.chkUser(map);
	}

	@Override
	public List<FindingMentorDto> chkMatching(Map<String, String> map) {
		log.info("chkMatching {}",map);
		return dao.chkMatching(map);
	}

	@Override
	public List<FindingMentorDto> chkComplete(Map<String, String> map) {
		log.info("chkComplete {}",map);
		return dao.chkComplete(map);
	}

	@Override
	public boolean updateComplete() {
		log.info("updateComplete");
		return dao.updateComplete();
	}

	@Override
	public boolean updateNoMatching(String boardseq) {
		log.info("updateNoMatching {}",boardseq);
		return dao.updateNoMatching(boardseq);
	}

	@Override
	public boolean deleteNoMatching() {
		log.info("deleteNoMatching");
		return dao.deleteNoMatching();
	}

	@Override
	public boolean deleteCompleteMatching() {
		log.info("deleteCompleteMatching");
		return dao.deleteCompleteMatching();
	}

}
