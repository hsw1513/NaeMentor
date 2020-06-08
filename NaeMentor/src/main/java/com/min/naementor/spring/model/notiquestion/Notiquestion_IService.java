package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.NotiQuestionDto;

public interface Notiquestion_IService {

	/**
	 * 공지 게시판 전체글 조회 (notiAll)
	 * @return 공지 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> notiAll();
	
	/**
	 * 공지 게시판 상세글 조회 (searchNoti)
	 * @param adminseq
	 * @return 공지게시판 상세글 정보
	 */
	public NotiQuestionDto searchNoti(String adminseq);
	
	/**
	 * 공지 게시판 게시글 입력
	 * @return boolean(true: 입력)
	 */
	public boolean insertNoti(NotiQuestionDto dto);
	
	/**
	 * 공지 게시판 게시글 수정
	 * @return boolean(true: 수정)
	 */
	public boolean modifyNoti(NotiQuestionDto dto);
	
	/**
	 * 공지 게시판 게시글 삭제
	 * @return boolean(true: 삭제)
	 */
	public boolean deleteNoti(Map<String, String[]> map);
	
	/**
	 * 공지 게시판 첨부파일 입력
	 * @return boolean(true: 첨부)
	 */
	public boolean insertFile(NotiQuestionDto dto);
	
	/**
	 * 공지 게시판 첨부파일 수정
	 * @return boolean(true: 수정)
	 */
	public boolean modifyFile(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 전체글 조회 (관리자)
	 * @return 1:1 문의 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> allOneToOneA();
	
	/**
	 * 1:1 문의 게시판 전체글 조회 (사용자)
	 * @return 1:1 문의 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> allOneToOneU();
	
	/**
	 * 1:1 문의 게시판 상세글 조회 (searchOneToOne)
	 * @param adminseq
	 * @return 1:1 문의 게시판 상세글 정보
	 */
	public NotiQuestionDto searchOneToOne(String adminseq);
	
	/**
	 * 1:1 문의 게시판 게시글 입력
	 * @return boolean(true: 입력)
	 */
	public boolean insertOneToOne(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 게시글 수정
	 * @return boolean(true: 수정)
	 */
	public boolean modifyOneToOne(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 게시글 삭제
	 * @return boolean(true: 삭제)
	 */
	public boolean deleteOneToOne(String adminseq);
	
	/**
	 * 1:1 문의 게시판 답글 입력
	 * @return boolean(true: 입력)
	 */
	public boolean insertReply(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 답글 수정
	 * @return boolean(true: 수정)
	 */
	public boolean modifyReply(NotiQuestionDto dto);
	
}
