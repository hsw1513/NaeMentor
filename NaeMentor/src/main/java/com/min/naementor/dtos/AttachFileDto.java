package com.min.naementor.dtos;

import java.io.Serializable;

public class AttachFileDto implements Serializable {

	private static final long serialVersionUID = 1722518200590321160L;
	
	private String fileseq    ;
	private String userfile   ;
	private String searchfile ;
	private String filesize   ;
	private String uploaddate ;
	private String filepath   ;
	private String adminseq   ;
	private String memberseq  ;
	
	public AttachFileDto() {
		
	}

	public AttachFileDto(String fileseq, String userfile, String searchfile, String filesize, String uploaddate,
			String filepath, String adminseq, String memberseq) {
		super();
		this.fileseq = fileseq;
		this.userfile = userfile;
		this.searchfile = searchfile;
		this.filesize = filesize;
		this.uploaddate = uploaddate;
		this.filepath = filepath;
		this.adminseq = adminseq;
		this.memberseq = memberseq;
	}

	public String getFileseq() {
		return fileseq;
	}

	public void setFileseq(String fileseq) {
		this.fileseq = fileseq;
	}

	public String getUserfile() {
		return userfile;
	}

	public void setUserfile(String userfile) {
		this.userfile = userfile;
	}

	public String getSearchfile() {
		return searchfile;
	}

	public void setSearchfile(String searchfile) {
		this.searchfile = searchfile;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getAdminseq() {
		return adminseq;
	}

	public void setAdminseq(String adminseq) {
		this.adminseq = adminseq;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	@Override
	public String toString() {
		return "AttachFile [fileseq=" + fileseq + ", userfile=" + userfile + ", searchfile=" + searchfile
				+ ", filesize=" + filesize + ", uploaddate=" + uploaddate + ", filepath=" + filepath + ", adminseq="
				+ adminseq + ", memberseq=" + memberseq + "]";
	}
	
	
	
	
}
