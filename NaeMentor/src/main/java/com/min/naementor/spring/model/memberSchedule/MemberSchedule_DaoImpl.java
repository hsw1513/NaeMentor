package com.min.naementor.spring.model.memberSchedule;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.MemberScheduleDto;
@Repository
public class MemberSchedule_DaoImpl implements MemberSchedule_IDao{
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS ="com.min.naementor.memberSchedule.";
	
	@Override
	public boolean insertSchedule(MemberScheduleDto dto) {
		return session.insert(NS+"insertSchedule", dto)>0?true:false;
	}

	@Override
	public boolean modifySchedule(MemberScheduleDto dto) {
		return session.update(NS+"modifySchedule", dto)>0?true:false;
	}

	@Override
	public boolean deleteSchedule(String boardseq) {
		return session.delete(NS+"deleteSchedule", boardseq)>0?true:false;
	}

}
