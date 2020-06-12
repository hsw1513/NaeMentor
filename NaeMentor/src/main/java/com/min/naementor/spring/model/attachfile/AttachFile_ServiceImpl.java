package com.min.naementor.spring.model.attachfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.AttachFileDto;
@Service
public class AttachFile_ServiceImpl implements AttachFile_IService{

	private Logger log = LoggerFactory.getLogger(AttachFile_ServiceImpl.class);
	@Autowired
	private AttachFile_IDao dao;
	
	@Override
	public AttachFileDto chkFile(String memberseq) {
		log.info("AttachFile_ServiceImpl_chkFile \t {}", memberseq);
		return dao.chkFile(memberseq);
	}
}
