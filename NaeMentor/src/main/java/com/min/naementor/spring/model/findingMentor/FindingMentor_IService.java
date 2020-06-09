package com.min.naementor.spring.model.findingMentor;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;

public interface FindingMentor_IService {
	/**
	 * 전체 글 조회
	 * @return List<FindingMentorDto>
	 */
	public List<FindingMentorDto> selectAll();
	/**
	 * 게시글 상세조회
	 * @param map(memberseq, memberseq)
	 * @return FindingMentorDto
	 */
	public FindingMentorDto detailContent(Map<String, String> map);
	/**
	 * 멘토링 신청
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 신청 성공)
	 */
	public boolean applyMentor(Map<String, String> map);
	// 멘토 중복 확인(다오에서 생성)
//	public boolean applyMentorChk(Map<String, String> map);
	/**
	 * 게시글 신고
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 신고 성공)
	 */
	public boolean reportCntUpdate(Map<String, String> map);
//	public boolean reportUserUpdate(Map<String, String> map);
//	public boolean reportContentChk(Map<String, String> map);
	/**
	 * 멘토찾기 글입력
	 * @param FindingMentorDto(title,content,specialfield,target,menteelevel,howto,location,memberseq )
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertContent(FindingMentorDto dto);
	/**
	 * 게시글 수정(글 불러오기)
	 * @param map(boardseq)
	 * @return FindingMentorDto
	 */
	public FindingMentorDto modifyContentSelect(Map<String, String> map);
	/**
	 * 게시글 수정(글 수정하기)
	 * @param dto(content,specialfield,target,menteelevel,howto,location,boardseq)
	 * @return boolean(true: 수정 성공)
	 */
	public boolean modifyContent(FindingMentorDto dto);
	/**
	 * 단일 삭제
	 * @param map(boardseq,memberseq)
	 * @return boolean(true: 삭제 성공)
	 */
	public boolean deleteContent(Map<String, String> map);
	/**
	 * 다중 삭제
	 * @param map("_memberseq":memberseq)
	 * @return boolean(true: 삭제 성공)
	 */
	public boolean multidelContent(Map<String, String[]> map);
	/**
	 * 멘토 선택(Matching게시판 insert)
	 * @param MatchingDto(boardseq,menteeseq,mentorseq)
	 * @return boolean(true: 매칭 성공)
	 */
	public boolean matching(MatchingDto dto);
	/**
	 * 신청한 멘토들의 아이디를 보여줌
	 * @param map(_memberseq,memberseq[])
	 * @return 멘토의 닉네임과 회원번호
	 */
	public List<NaememberDto> chkMentor(Map<String, String[]> map);
}
