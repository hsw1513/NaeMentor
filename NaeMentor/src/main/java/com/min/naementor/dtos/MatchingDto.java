package com.min.naementor.dtos;

import java.io.Serializable;

public class MatchingDto implements Serializable{

	private static final long serialVersionUID = 6325050503958246034L;
	private String boardseq;
	private String menteeseq;
	private String mentorseq;
	private String matchingdate;
	private String payflag;
	
	private FindingMentorDto findingmentordto;
	
	public MatchingDto() {
	}

	public MatchingDto(String boardseq, String menteeseq, String mentorseq, String matchingdate, String payflag,
			FindingMentorDto findingmentordto) {
		super();
		this.boardseq = boardseq;
		this.menteeseq = menteeseq;
		this.mentorseq = mentorseq;
		this.matchingdate = matchingdate;
		this.payflag = payflag;
		this.findingmentordto = findingmentordto;
	}

	@Override
	public String toString() {
		return "MatchingDto [boardseq=" + boardseq + ", menteeseq=" + menteeseq + ", mentorseq=" + mentorseq
				+ ", matchingdate=" + matchingdate + ", payflag=" + payflag + ", findingmentordto=" + findingmentordto
				+ "]";
	}

	public String getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}

	public String getMenteeseq() {
		return menteeseq;
	}

	public void setMenteeseq(String menteeseq) {
		this.menteeseq = menteeseq;
	}

	public String getMentorseq() {
		return mentorseq;
	}

	public void setMentorseq(String mentorseq) {
		this.mentorseq = mentorseq;
	}

	public String getMatchingdate() {
		return matchingdate;
	}

	public void setMatchingdate(String matchingdate) {
		this.matchingdate = matchingdate;
	}

	public String getPayflag() {
		return payflag;
	}

	public void setPayflag(String payflag) {
		this.payflag = payflag;
	}

	public FindingMentorDto getFindingmentordto() {
		return findingmentordto;
	}

	public void setFindingmentordto(FindingMentorDto findingmentordto) {
		this.findingmentordto = findingmentordto;
	}
	
	
	
}
