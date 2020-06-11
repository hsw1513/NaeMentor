package com.min.naementor.spring.comm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.min.naementor.dtos.AttachFileDto;

@Component
public class AttachFile_Module {
	
	
	private String memberseq;
	private String adminseq;
	private AttachFileDto dto;

	// 이미지 미리보기
	@SuppressWarnings("unchecked")
	public JSONObject ckImgUpload(MultipartFile upload, HttpServletRequest request, HttpServletResponse resp) {
		String url = request.getContextPath()+"/img/";
		String rootPath = request.getRealPath("/img");
		System.out.println(rootPath);
		File file = new File(rootPath);
		String fileName = "";
		if(!file.exists()) { file.mkdir();	}
		int uploaded = 0;
		
		fileName = upload.getOriginalFilename();
		System.out.println(fileName);
		File f = new File(rootPath, fileName);
		try {
			upload.transferTo(f);
			uploaded++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
			obj.put("uploaded", uploaded);
			obj.put("url", url+fileName);
			obj.put("fileName", fileName);
		return obj;	
	}

	public List<AttachFileDto> attachFile(List<MultipartFile> files, HttpServletRequest request, HttpServletResponse resp) {
		List<AttachFileDto> lists = new ArrayList<AttachFileDto>();
		String url = request.getContextPath()+"/files/";
		String filepath = request.getRealPath("/files");
		System.out.println(url);
		File file = new File(url);
		if(!file.exists()) { file.mkdir();	}
		// 파일 넣기
		for (MultipartFile multipartFile : files) {
		
		String userfile = multipartFile.getOriginalFilename();
		String searchfile = UUID.randomUUID().toString() + userfile;
		String filesize ="" ;
		dto = new AttachFileDto();
		File f = new File(url, searchfile);
		boolean isc = false;
		try {
			filesize = String.valueOf(multipartFile.getSize());
			multipartFile.transferTo(f);
			isc = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(isc) {
		dto.setFilepath(url);
		dto.setFilesize(filesize);
		dto.setSearchfile(searchfile);
		dto.setUserfile(userfile);
		if(memberseq != null) {
			dto.setMemberseq(memberseq);
		}
		if(adminseq != null) {
			dto.setAdminseq(adminseq);
		}
		System.out.println(dto);
		lists.add(dto);
		}
		}
		return lists;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getAdminseq() {
		return adminseq;
	}

	public void setAdminseq(String adminseq) {
		this.adminseq = adminseq;
	}
	
	public AttachFileDto getDto() {
		return dto;
	}

	
}
