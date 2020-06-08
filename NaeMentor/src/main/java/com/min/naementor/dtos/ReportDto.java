package com.min.naementor.dtos;

import java.io.Serializable;

public class ReportDto implements Serializable{

	private static final long serialVersionUID = 5188326285249836915L;
	private String singomember	;
	private String singoedmember	;
	private String singoreason	;
	private String singochk		;
	private String reviewseq		;
	private String boardseq		;
	
	private ReviewDto reviewdto;
	
	public ReportDto() {
	}

	public ReportDto(String singomember, String singoedmember, String singoreason, String singochk, String reviewseq,
			String boardseq, ReviewDto reviewdto) {
		super();
		this.singomember = singomember;
		this.singoedmember = singoedmember;
		this.singoreason = singoreason;
		this.singochk = singochk;
		this.reviewseq = reviewseq;
		this.boardseq = boardseq;
		this.reviewdto = reviewdto;
	}

	@Override
	public String toString() {
		return "ReportDto [singomember=" + singomember + ", singoedmember=" + singoedmember + ", singoreason="
				+ singoreason + ", singochk=" + singochk + ", reviewseq=" + reviewseq + ", boardseq=" + boardseq
				+ ", reviewdto=" + reviewdto + "]";
	}

	public String getSingomember() {
		return singomember;
	}

	public void setSingomember(String singomember) {
		this.singomember = singomember;
	}

	public String getSingoedmember() {
		return singoedmember;
	}

	public void setSingoedmember(String singoedmember) {
		this.singoedmember = singoedmember;
	}

	public String getSingoreason() {
		return singoreason;
	}

	public void setSingoreason(String singoreason) {
		this.singoreason = singoreason;
	}

	public String getSingochk() {
		return singochk;
	}

	public void setSingochk(String singochk) {
		this.singochk = singochk;
	}

	public String getReviewseq() {
		return reviewseq;
	}

	public void setReviewseq(String reviewseq) {
		this.reviewseq = reviewseq;
	}

	public String getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}

	public ReviewDto getReviewdto() {
		return reviewdto;
	}

	public void setReviewdto(ReviewDto reviewdto) {
		this.reviewdto = reviewdto;
	}
	
	

}
