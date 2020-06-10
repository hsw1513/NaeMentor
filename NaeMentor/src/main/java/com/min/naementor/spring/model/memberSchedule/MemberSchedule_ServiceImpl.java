package com.min.naementor.spring.model.memberSchedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.MemberScheduleDto;
@Service
public class MemberSchedule_ServiceImpl implements MemberSchedule_IService{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MemberSchedule_IDao dao;
	
	@Override
	public boolean insertSchedule(MemberScheduleDto dto) {
		log.info("MemberSchedule_ServiceImpl insertSchedule {}",dto);
		return dao.insertSchedule(dto);
	}

	@Override
	public boolean modifySchedule(MemberScheduleDto dto) {
		log.info("MemberSchedule_ServiceImpl modifySchedule {}",dto);
		return dao.modifySchedule(dto);
	}

	@Override
	public boolean deleteSchedule(String boardseq) {
		log.info("MemberSchedule_ServiceImpl deleteSchedule {}",boardseq);
		return dao.deleteSchedule(boardseq);
	}

	@Override
	public MemberScheduleDto chkSchedule(String boardseq) {
		log.info("MemberSchedule_ServiceImpl chkSchedule {}",boardseq);
		return dao.chkSchedule(boardseq);
	}

}
