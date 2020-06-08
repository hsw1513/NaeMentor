package com.min.naementor.dtos;

import java.io.Serializable;

public class NotiQuestionDto implements Serializable {

	private static final long serialVersionUID = -9083691329807327110L;
	
	private String adminseq;
	private String title;
	private String content;
	private String writedate;
	private String delflag;
	private String reference;
	private String boardtype;
	private String memberseq;
	
	private NaememberDto namemberdto;
	private AttachFileDto attachfiledto;
	
	public NotiQuestionDto() {
		// TODO Auto-generated constructor stub
	}

	public NotiQuestionDto(String adminseq, String title, String content, String writedate, String delflag,
			String reference, String boardtype, String memberseq, NaememberDto namemberdto,
			AttachFileDto attachfiledto) {
		super();
		this.adminseq = adminseq;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
		this.delflag = delflag;
		this.reference = reference;
		this.boardtype = boardtype;
		this.memberseq = memberseq;
		this.namemberdto = namemberdto;
		this.attachfiledto = attachfiledto;
	}

	@Override
	public String toString() {
		return "NotiQuestionDto [adminseq=" + adminseq + ", title=" + title + ", content=" + content + ", writedate="
				+ writedate + ", delflag=" + delflag + ", reference=" + reference + ", boardtype=" + boardtype
				+ ", memberseq=" + memberseq + ", namemberdto=" + namemberdto + ", attachfiledto=" + attachfiledto
				+ "]";
	}

	public String getAdminseq() {
		return adminseq;
	}

	public void setAdminseq(String adminseq) {
		this.adminseq = adminseq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getBoardtype() {
		return boardtype;
	}

	public void setBoardtype(String boardtype) {
		this.boardtype = boardtype;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public NaememberDto getNamemberdto() {
		return namemberdto;
	}

	public void setNamemberdto(NaememberDto namemberdto) {
		this.namemberdto = namemberdto;
	}

	public AttachFileDto getAttachfiledto() {
		return attachfiledto;
	}

	public void setAttachfiledto(AttachFileDto attachfiledto) {
		this.attachfiledto = attachfiledto;
	}
	
	
	
	
	
}
