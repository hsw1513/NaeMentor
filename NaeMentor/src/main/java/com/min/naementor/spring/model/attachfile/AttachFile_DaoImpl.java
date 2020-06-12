package com.min.naementor.spring.model.attachfile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.AttachFileDto;

@Repository
public class AttachFile_DaoImpl implements AttachFile_IDao{
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.min.naementor.attachfile.";
	
	@Override
	public AttachFileDto chkFile(String memberseq) {
		return (AttachFileDto)session.selectList(NS+"chkFile", memberseq).get(0);
	}
}
