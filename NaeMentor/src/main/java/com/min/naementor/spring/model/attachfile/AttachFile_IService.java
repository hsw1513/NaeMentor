package com.min.naementor.spring.model.attachfile;

import com.min.naementor.dtos.AttachFileDto;

public interface AttachFile_IService {

	/**
	 * 프로필에서 파일 정보를 가져오는 기능
	 * @param memberseq
	 * @return AttachFileDto
	 */
	public AttachFileDto chkFile(String memberseq);
}
