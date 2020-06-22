package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NotiQuestionDto;
import com.min.naementor.spring.comm.RowNumUtil;

@Service
public class Notiquestion_ServiceImpl implements Notiquestion_IService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Notiquestion_IDao dao;
	
	@Override
	public List<NotiQuestionDto> notiAll(RowNumUtil rUtil) {
		log.info("notiAll 전체 글 조회", rUtil);
		return dao.notiAll(rUtil);
	}
	
	@Override
	public NotiQuestionDto searchNoti(String adminseq) {
		log.info("searchNoti 상세글 조회", adminseq);
		return dao.searchNoti(adminseq);
	}
	
	@Override
	public int insertNoti(NotiQuestionDto dto) {
		log.info("insertNoti 새글 작성", dto);
		return dao.insertNoti(dto);
	}

	@Override
	public int modifyNoti(NotiQuestionDto dto) {
		log.info("modifyNoti 게시글 수정", dto);
		return dao.modifyNoti(dto);
	}

	@Override
	public int deleteNoti(String adminseq) {
		log.info("deleteNoti 게시글 삭제", adminseq);
		return dao.deleteNoti(adminseq);
	}

	@Override
	public int multiDeleteNoti(Map<String, Object> adminseqs) {
		log.info("multiDeleteNoti 게시글 다중삭제", adminseqs);
		return dao.multiDeleteNoti(adminseqs);
	}

	@Override
	public int insertFile(AttachFileDto dto) {
		log.info("insertFile 첨부파일 등록", dto);
		return dao.insertFile(dto);
	}

	@Override
	public int modifyFile(AttachFileDto dto) {
		log.info("modifyFile 첨부파일 수정", dto);
		return dao.modifyFile(dto);
	}
	
	@Override
	public List<NotiQuestionDto> allOneToOneA(RowNumUtil rUtil) {
		log.info("allOneToOneA 전체글 조회 (관리자)", rUtil);
		return dao.allOneToOneA(rUtil);
	}

	@Override
	public List<NotiQuestionDto> allOneToOneU(String memberseq) {
		log.info("allOneToOneU 전체글 조회 (사용자)", memberseq);
		return dao.allOneToOneU(memberseq);
	}

	@Override
	public NotiQuestionDto searchOneToOne(String adminseq) {
		log.info("searchOneToOne 상세글 조회", adminseq);
		return dao.searchOneToOne(adminseq);
	}

	@Override
	public int insertOneToOne(NotiQuestionDto dto) {
		log.info("insertOneToOne 새글 작성", dto);
		return dao.insertOneToOne(dto);
	}

	@Override
	public int modifyOneToOne(NotiQuestionDto dto) {
		log.info("modifyOneToOne 게시글 수정", dto);
		return dao.modifyOneToOne(dto);
	}

	@Override
	public int deleteOneToOne(String adminseq) {
		log.info("deleteOneToOne 게시글 삭제", adminseq);
		return dao.deleteOneToOne(adminseq);
	}

	@Override
	public int insertReply(NotiQuestionDto dto) {
		log.info("insertReply 답글 작성", dto);
		return dao.insertReply(dto);
	}

	@Override
	public int modifyReply(NotiQuestionDto dto) {
		log.info("modifyReply 답글 수정", dto);
		return dao.modifyReply(dto);
	}

	@Override
	public int notiBoardListTotal() {
		log.info("notiBoardListTotal 공지사항 전체 글의 개수");
		return dao.notiBoardListTotal();
	}



	@Override
	public int OtOBoardListTotal() {
		log.info("OtOBoardListTotal 1:1 문의사항 전체 글의 개수");
		return dao.OtOBoardListTotal();
	}

}
