package com.min.naementor.dtos;

import java.io.Serializable;

public class MemberScheduleDto implements Serializable{

	private static final long serialVersionUID = -2067207425486135740L;
	private String boardseq;
	private String mentoringplace;
	private String mentoringtime;
	public MemberScheduleDto() {
	}
	public MemberScheduleDto(String boardseq, String mentoringplace, String mentoringtime) {
		super();
		this.boardseq = boardseq;
		this.mentoringplace = mentoringplace;
		this.mentoringtime = mentoringtime;
	}
	@Override
	public String toString() {
		return "MemberScheduleDto [boardseq=" + boardseq + ", mentoringplace=" + mentoringplace + ", mentoringtime="
				+ mentoringtime + "]";
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	public String getMentoringplace() {
		return mentoringplace;
	}
	public void setMentoringplace(String mentoringplace) {
		this.mentoringplace = mentoringplace;
	}
	public String getMentoringtime() {
		return mentoringtime;
	}
	public void setMentoringtime(String mentoringtime) {
		this.mentoringtime = mentoringtime;
	}
	
	

}
