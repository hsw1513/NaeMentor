package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.spring.comm.RowNumUtil;

public interface Notiquestion_IDao {

	/**
	 * 공지 게시판 전체글 조회 (notiAll)
	 * @return 공지 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> notiAll(RowNumUtil rUtil);
	
	/**
	 *공지게시판 전체글 개수
	 * @return int
	 */
	public int notiBoardListTotal();
	
	/**
	 * 공지 게시판 상세글 조회 (searchNoti)
	 * @param adminseq
	 * @return 공지게시판 상세글 정보
	 */
	public NotiQuestionDto searchNoti(String adminseq);
	
	/**
	 * 공지 게시판 게시글 입력
	 * @return int
	 */
	public int insertNoti(NotiQuestionDto dto);
	
	/**
	 * 공지 게시판 게시글 수정
	 * @return int
	 */
	public int modifyNoti(NotiQuestionDto dto);
	
	/**
	 * 공지 게시판 게시글 삭제
	 * @return int
	 */
	public int deleteNoti(String adminseq);
	
	/**
	 * 공지 게시판 게시글 다중 삭제
	 * @return int
	 */
	public int multiDeleteNoti(Map<String, Object> adminseqs);
	
	/**
	 * 공지 게시판 첨부파일 입력
	 * @return int
	 */
	public int insertFile(AttachFileDto dto);
	
	/**
	 * 공지 게시판 첨부파일 수정
	 * @return int
	 */
	public int modifyFile(AttachFileDto dto);
	
	/**
	 * 1:1 문의 게시판 전체글 조회 (관리자)
	 * @return 1:1 문의 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> allOneToOneA(RowNumUtil rUtil);
	
	/**
	 *공지게시판 전체글 개수
	 * @return int
	 */
	public int OtOBoardListTotal();
	
	/**
	 * 1:1 문의 게시판 전체글 조회 (사용자)
	 * @return 1:1 문의 게시판 전체글 리스트 정보
	 */
	public List<NotiQuestionDto> allOneToOneU(String memberseq);
	
	/**
	 * 1:1 문의 게시판 상세글 조회 (searchOneToOne)
	 * @param adminseq
	 * @return 1:1 문의 게시판 상세글 정보
	 */
	public NotiQuestionDto searchOneToOne(String adminseq);
	
	/**
	 * 1:1 문의 게시판 게시글 입력
	 * @return int
	 */
	public int insertOneToOne(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 게시글 수정
	 * @return int
	 */
	public int modifyOneToOne(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 게시글 삭제
	 * @return int
	 */
	public int deleteOneToOne(String adminseq);
	
	/**
	 * 1:1 문의 게시판 답글 입력
	 * @return int
	 */
	public int insertReply(NotiQuestionDto dto);
	
	/**
	 * 1:1 문의 게시판 답글 수정
	 * @return int
	 */
	public int modifyReply(NotiQuestionDto dto);
}
