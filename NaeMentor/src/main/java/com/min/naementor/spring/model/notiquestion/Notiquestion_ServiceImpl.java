package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.NotiQuestionDto;

@Service
public class Notiquestion_ServiceImpl implements Notiquestion_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IDao dao;
	
	/**
	 * <h2>공지 게시판 전체글 조회</h2>
	 * @return 전체글에 대한 리스트
	 */
	@Override
	public List<NotiQuestionDto> notiAll() {
		log.info("notiAll 전체 글 조회");
		return dao.notiAll();
	}
	/**
	 * <h2>공지 게시판 상세글 조회</h2>
	 * @param 식별자 adminseq, 닉네임, 제목, 내용
	 * @return notiquestionDto
	 */
	@Override
	public NotiQuestionDto searchNoti(String adminseq) {
		log.info("searchNoti 상세글 조회", adminseq);
		return dao.searchNoti(adminseq);
	}
	/**
	 * <h2>공지 게시판 새글 등록</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int insertNoti(NotiQuestionDto dto) {
		log.info("insertNoti 새글 작성", dto);
		return dao.insertNoti(dto);
	}

	/**
	 * <h2>공지 게시판 게시글 수정</h2>
	 * @param 식별자 adminseq, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int modifyNoti(NotiQuestionDto dto) {
		log.info("modifyNoti 게시글 수정", dto);
		return dao.modifyNoti(dto);
	}

	/**
	 * <h2>공지 게시판 게시글 삭제</h2>
	 * @param 식별자 adminseq
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int deleteNoti(String adminseq) {
		log.info("deleteNoti 게시글 삭제", adminseq);
		return dao.deleteNoti(adminseq);
	}
	/**
	 * <h2>공지 게시판 게시글 다중 삭제</h2>
	 * @param 식별자 adminseqs
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int multiDeleteNoti(Map<String, Object> adminseqs) {
		log.info("multiDeleteNoti 게시글 다중삭제", adminseqs);
		return dao.multiDeleteNoti(adminseqs);
	}

	/**
	 * <h2>공지 게시판 첨부파일 등록</h2>
	 * @param 닉네임, 파일이름
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int insertFile(NotiQuestionDto dto) {
		log.info("insertFile 첨부파일 등록", dto);
		return dao.insertFile(dto);
	}

	/**
	 * <h2>공지 게시판 첨부파일 수정</h2>
	 * @param 닉네임, 첨부파일
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int modifyFile(NotiQuestionDto dto) {
		log.info("modifyFile 첨부파일 수정", dto);
		return dao.modifyFile(dto);
	}
	
	/**
	 * <h2>1:1 문의 게시판 전체 조회 (관리자)</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public List<NotiQuestionDto> allOneToOneA() {
		log.info("allOneToOneA 전체글 조회 (관리자)");
		return dao.allOneToOneA();
	}

	/**
	 * <h2>1:1 문의 게시판 전체글 조회 (사용자)</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public List<NotiQuestionDto> allOneToOneU() {
		log.info("allOneToOneU 전체글 조회 (사용자)");
		return dao.allOneToOneU();
	}

	/**
	 * <h2>1:1 문의 게시판 상세글 조회</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public NotiQuestionDto searchOneToOne(String adminseq) {
		log.info("searchOneToOne 상세글 조회", adminseq);
		return dao.searchOneToOne(adminseq);
	}

	/**
	 * <h2>1:1 문의 게시판 새글 등록</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int insertOneToOne(NotiQuestionDto dto) {
		log.info("insertOneToOne 새글 작성", dto);
		return dao.insertOneToOne(dto);
	}

	/**
	 * <h2>1:1 문의 게시판 게시글 수정</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int modifyOneToOne(NotiQuestionDto dto) {
		log.info("modifyOneToOne 게시글 수정", dto);
		return dao.modifyOneToOne(dto);
	}

	/**
	 * <h2>1:1 문의 게시판 게시글 삭제</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int deleteOneToOne(String adminseq) {
		log.info("deleteOneToOne 게시글 삭제", adminseq);
		return dao.deleteOneToOne(adminseq);
	}

	/**
	 * <h2>1:1 문의 게시판 답글 등록</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int insertReply(NotiQuestionDto dto) {
		log.info("insertReply 답글 작성", dto);
		return dao.insertReply(dto);
	}

	/**
	 * <h2>1:1 문의 게시판 답글 수정</h2>
	 * @param 닉네임, 제목, 내용
	 * @return 성공여부 (성공 true)
	 */
	@Override
	public int modifyReply(NotiQuestionDto dto) {
		log.info("modifyReply 답글 수정", dto);
		return dao.modifyReply(dto);
	}

}
