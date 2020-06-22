package com.min.naementor.spring.model.findingMentor;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.FindingMentorDto;
import com.min.naementor.dtos.MatchingDto;
import com.min.naementor.dtos.NaememberDto;

public interface FindingMentor_IDao {

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

	/**
	 * 지원자 중복 확인
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 지원 가능)
	 */
	public boolean applyMentorChk(Map<String, String> map);

	/**
	 * 게시글 신고
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 신고 성공)
	 */
	public boolean reportCntUpdate(Map<String, String> map);

	/**
	 * 게시글 신고 User추가
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 추가 성공)
	 */
	public boolean reportUserUpdate(Map<String, String> map);

	/**
	 * 게시글 신고자 중복체크
	 * @param map(boardseq, memberseq)
	 * @return boolean(true: 신고 가능)
	 */
	public boolean reportContentChk(Map<String, String> map);

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
	public List<NaememberDto> chkUser(Map<String, String[]> map);

	/**
	 * 매칭에 성공하면 board의 매칭을 Y로 변경
	 * @param boardseq(변경할 게시판의 boardseq)
	 * @return boolean(true:변경성공)
	 */
	public boolean updateMatching(String boardseq);

	// 2020.06.16 추가 내용
	/**
	 * 매칭이 되어있는 글들을 조회
	 * @param mentorseq / menteeseq
	 * @return List<FindingMentorDto>
	 */
	public List<FindingMentorDto> chkMatching(Map<String,String> map);

	/**
	 * 멘토링이 종료된 글 중 후기가 모두 입력되지 않은 글 조회
	 * @param mentorseq / menteeseq
	 * @return List<FindingMentorDto>
	 */
	public List<FindingMentorDto> chkComplete(Map<String,String> map);

	/**
	 * 후기가 모두 남겨진 글 삭제
	 * @return boolean(true:삭제 완료)
	 */
	public boolean updateComplete();

	/**
	 * 매칭이 안되었을 시 글 삭제
	 * @param boardseq
	 * @return boolean(true:삭제 성공)
	 */
	public boolean updateNoMatching(String boardseq);
	
	/**
	 * 매칭 안된 글 이틀 후 지우기
	 * @return 삭제 성공 여부
	 */
	public boolean deleteNoMatching();
	
	/**
	 * 멘토링 날짜 후 3일이 지난 글 삭제
	 * @return 삭제 성공 여부
	 */
	public boolean deleteCompleteMatching();

}
