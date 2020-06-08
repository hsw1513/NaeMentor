package com.min.naementor.dtos;

import java.io.Serializable;

public class MemberScheduleDto implements Serializable{

	private static final long serialVersionUID = -2067207425486135740L;
	private String boardseq;
	private String mentoringplace;
	private String mentoringtime;
	
	private MatchingDto matchingdto;
	
	public MemberScheduleDto() {
	}

	public MemberScheduleDto(String boardseq, String mentoringplace, String mentoringtime, MatchingDto matchingdto) {
		super();
		this.boardseq = boardseq;
		this.mentoringplace = mentoringplace;
		this.mentoringtime = mentoringtime;
		this.matchingdto = matchingdto;
	}

	@Override
	public String toString() {
		return "MemberScheduleDto [boardseq=" + boardseq + ", mentoringplace=" + mentoringplace + ", mentoringtime="
				+ mentoringtime + ", matchingdto=" + matchingdto + "]";
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

	public MatchingDto getMatchingdto() {
		return matchingdto;
	}

	public void setMatchingdto(MatchingDto matchingdto) {
		this.matchingdto = matchingdto;
	}

	

}
