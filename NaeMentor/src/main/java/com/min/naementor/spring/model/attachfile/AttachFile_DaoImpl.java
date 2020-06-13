package com.min.naementor.spring.model.attachfile;

import java.util.List;

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
		List<AttachFileDto> lists = session.selectList(NS+"chkFile", memberseq);
		if(lists.size()!=0) {
			return (AttachFileDto)lists.get(0);
		}else {
			AttachFileDto dto = new AttachFileDto();
			dto.setMemberseq(memberseq);
			dto.setUserfile("파일없음");
			return dto;
		}
	}
}
