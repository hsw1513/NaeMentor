package com.min.naementor.spring.model.memberSchedule;

import com.min.naementor.dtos.MemberScheduleDto;

public interface MemberSchedule_IDao {
	/**
	 * 스케줄 입력
	 * @param dto(BOARDSEQ, MENTORINGPLACE, MENTORINGTIME)
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertSchedule(MemberScheduleDto dto);
	/**
	 * 스케줄 수정
	 * @param dto(BOARDSEQ, MENTORINGPLACE, MENTORINGTIME)
	 * @return boolean(true: 입력 성공)
	 */
	public boolean modifySchedule(MemberScheduleDto dto);
	/**
	 * 스케줄 삭제
	 * @param boardseq
	 * @return boolean(true: 삭제 성공)
	 */
	public boolean deleteSchedule(String boardseq);
}
