package com.min.naementor.spring.model.notiquestion;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public boolean insertNoti(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertNoti", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyNoti(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyNoti", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean deleteNoti(Map<String, String[]> map) {
		int n = sqlSession.update(NS+"deleteNoti", map);
		return (n>0)?true:false;
	}

	@Override
	public boolean insertFile(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertFile", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyFile(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyFile", dto);
		return (n>0)?true:false;
	}

	@Override
	public List<NotiQuestionDto> allOneToOneA() {
		return sqlSession.selectList(NS+"allOneToOneA");
	}

	@Override
	public List<NotiQuestionDto> allOneToOneU() {
		return sqlSession.selectList(NS+"allOneToOneU");
	}

	@Override
	public NotiQuestionDto searchOneToOne(String adminseq) {
		return sqlSession.selectOne(NS+"searchOneToOne", adminseq);
	}

	@Override
	public boolean insertOneToOne(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertOneToOne", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyOneToOne(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyOneToOne", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean deleteOneToOne(String adminseq) {
		int n = sqlSession.update(NS+"deleteOneToOne", adminseq);
		return (n>0)?true:false;
	}

	@Override
	public boolean insertReply(NotiQuestionDto dto) {
		int n = sqlSession.insert(NS+"insertReply", dto);
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyReply(NotiQuestionDto dto) {
		int n = sqlSession.update(NS+"modifyReply", dto);
		return (n>0)?true:false;
	}

}
