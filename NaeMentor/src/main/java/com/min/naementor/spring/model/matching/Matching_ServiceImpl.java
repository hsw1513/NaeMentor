package com.min.naementor.spring.model.matching;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.MatchingDto;

@Service
public class Matching_ServiceImpl implements Matching_IService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Matching_IDao dao;
	
	@Override
	public MatchingDto chkMatching(String boardseq) {
		log.info("Matching_ServiceImpl chkMatching \t {}",boardseq);
		return dao.chkMatching(boardseq);
	}

	@Override
	public boolean chkMatchingCount(String boardseq) {
		log.info("Matching_ServiceImpl chkMatchingCount \t {}",boardseq);
		return dao.chkMatchingCount(boardseq);
	}

}
