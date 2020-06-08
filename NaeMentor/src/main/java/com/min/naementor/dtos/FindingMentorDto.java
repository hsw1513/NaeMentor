package com.min.naementor.dtos;

import java.io.Serializable;

public class FindingMentorDto implements Serializable{

	private static final long serialVersionUID = 9175405026471946605L;
	private String boardseq;
	private String title;
	private String content;
	private String writesdate;
	private String reportcnt;
	private String specialfield;
	private String target;
	private String menteelevel;
	private String howto;
	private String location;
	private String delflag;
	private String mentorlist;
	private String memberseq;
	private String findreporter;
	
	public FindingMentorDto() {
	}

	public FindingMentorDto(String boardseq, String title, String content, String writesdate, String reportcnt,
			String specialfield, String target, String menteelevel, String howto, String location, String delflag,
			String mentorlist, String memberseq, String findreporter) {
		super();
		this.boardseq = boardseq;
		this.title = title;
		this.content = content;
		this.writesdate = writesdate;
		this.reportcnt = reportcnt;
		this.specialfield = specialfield;
		this.target = target;
		this.menteelevel = menteelevel;
		this.howto = howto;
		this.location = location;
		this.delflag = delflag;
		this.mentorlist = mentorlist;
		this.memberseq = memberseq;
		this.findreporter = findreporter;
	}

	@Override
	public String toString() {
		return "FindingmentorDto [boardseq=" + boardseq + ", title=" + title + ", content=" + content + ", writesdate="
				+ writesdate + ", reportcnt=" + reportcnt + ", specialfield=" + specialfield + ", target=" + target
				+ ", menteelevel=" + menteelevel + ", howto=" + howto + ", location=" + location + ", delflag="
				+ delflag + ", mentorlist=" + mentorlist + ", memberseq=" + memberseq + ", findreporter=" + findreporter
				+ "]";
	}

	public String getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
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

	public String getWritesdate() {
		return writesdate;
	}

	public void setWritesdate(String writesdate) {
		this.writesdate = writesdate;
	}

	public String getReportcnt() {
		return reportcnt;
	}

	public void setReportcnt(String reportcnt) {
		this.reportcnt = reportcnt;
	}

	public String getSpecialfield() {
		return specialfield;
	}

	public void setSpecialfield(String specialfield) {
		this.specialfield = specialfield;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMenteelevel() {
		return menteelevel;
	}

	public void setMenteelevel(String menteelevel) {
		this.menteelevel = menteelevel;
	}

	public String getHowto() {
		return howto;
	}

	public void setHowto(String howto) {
		this.howto = howto;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getMentorlist() {
		return mentorlist;
	}

	public void setMentorlist(String mentorlist) {
		this.mentorlist = mentorlist;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getFindreporter() {
		return findreporter;
	}

	public void setFindreporter(String findreporter) {
		this.findreporter = findreporter;
	}
	
	
	
	
	
}
