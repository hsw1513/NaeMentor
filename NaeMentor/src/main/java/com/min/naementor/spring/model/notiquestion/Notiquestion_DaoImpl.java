package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.AttachFileDto;
import com.min.naementor.dtos.NotiQuestionDto;

@Repository
public class Notiquestion_DaoImpl implements Notiquestion_IDao {
	
	private final String NS = "com.min.naementor.notiquestion.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NotiQuestionDto> notiAll() {
		return sqlSession.selectList(NS+"notiAll");
	}

	@Override
	public NotiQuestionDto searchNoti(String adminseq) {
		return sqlSession.selectOne(NS+"searchNoti", adminseq);
	}

	@Override
	public int insertNoti(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertNoti", dto);
		return n;
	}

	@Override
	public int modifyNoti(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyNoti", dto);
		return n;
	}

	@Override
	public int deleteNoti(String adminseq) {
		return sqlSession.update(NS+"deleteNoti", adminseq);
	}
	
	@Override
	public int multiDeleteNoti(Map<String, Object> adminseqs) {
		return sqlSession.update(NS+"multiDeleteNoti", adminseqs);
	}
	
	@Override
	public int insertFile(AttachFileDto dto) {
		int n = sqlSession.insert(NS+"insertFile", dto);
		return n;
	}

	@Override
	public int modifyFile(AttachFileDto dto) {
		int n = sqlSession.update(NS+"modifyFile", dto);
		return n;
	}

	@Override
	public List<NotiQuestionDto> allOneToOneA() {
		return sqlSession.selectList(NS+"allOneToOneA");
	}

	@Override
	public List<NotiQuestionDto> allOneToOneU(String memberseq) {
		return sqlSession.selectList(NS+"allOneToOneU", memberseq);
	}

	@Override
	public NotiQuestionDto searchOneToOne(String adminseq) {
		return sqlSession.selectOne(NS+"searchOneToOne", adminseq);
	}

	@Override
	public int insertOneToOne(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertOneToOne", dto);
		return n;
	}

	@Override
	public int modifyOneToOne(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyOneToOne", dto);
		return n;
	}

	@Override
	public int deleteOneToOne(String adminseq) {
		int n = sqlSession.update(NS+"deleteOneToOne", adminseq);
		return n;
	}

	@Override
	public int insertReply(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertReply", dto);
		return n;
	}

	@Override
	public int modifyReply(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyReply", dto);
		return n;
	}

}
