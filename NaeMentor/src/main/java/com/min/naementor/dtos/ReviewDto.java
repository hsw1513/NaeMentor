package com.min.naementor.dtos;

import java.io.Serializable;

public class ReviewDto implements Serializable{

	private static final long serialVersionUID = 8409987817159001540L;
	private String reviewseq;
	private String boardseq;
	private String content;
	private String writedate;
	private String delflag;
	private String mentorstar;
	private String menteestar;
	
	public ReviewDto() {
	}

	public ReviewDto(String reviewseq, String boardseq, String content, String writedate, String delflag,
			String mentorstar, String menteestar) {
		super();
		this.reviewseq = reviewseq;
		this.boardseq = boardseq;
		this.content = content;
		this.writedate = writedate;
		this.delflag = delflag;
		this.mentorstar = mentorstar;
		this.menteestar = menteestar;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewseq=" + reviewseq + ", boardseq=" + boardseq + ", content=" + content + ", writedate="
				+ writedate + ", delflag=" + delflag + ", mentorstar=" + mentorstar + ", menteestar=" + menteestar
				+ "]";
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

	public String getMentorstar() {
		return mentorstar;
	}

	public void setMentorstar(String mentorstar) {
		this.mentorstar = mentorstar;
	}

	public String getMenteestar() {
		return menteestar;
	}

	public void setMenteestar(String menteestar) {
		this.menteestar = menteestar;
	}
	
	
}
