package com.min.naementor.dtos;

import java.io.Serializable;

public class ProfileDto implements Serializable {
	
	private static final long serialVersionUID = -2992432246437659373L;
	
	private String memberseq   ;
	private String photo       ;
	private String school      ;
	private String major       ;
	private String career      ;
	private String certificate ;
	private String specialfield;
	private String pmdate      ;
	private String mentorcnt   ;
	private String mentoaccstar;
	private String filechk     ;
	
	private AttachFileDto attachfiledto;
	
	public ProfileDto() {
		// TODO Auto-generated constructor stub
	}

	public ProfileDto(String memberseq, String photo, String school, String major, String career, String certificate,
			String specialfield, String pmdate, String mentorcnt, String mentoaccstar, String filechk,
			ProfileDto profiledto) {
		super();
		this.memberseq = memberseq;
		this.photo = photo;
		this.school = school;
		this.major = major;
		this.career = career;
		this.certificate = certificate;
		this.specialfield = specialfield;
		this.pmdate = pmdate;
		this.mentorcnt = mentorcnt;
		this.mentoaccstar = mentoaccstar;
		this.filechk = filechk;
		this.attachfiledto = attachfiledto;
	}

	@Override
	public String toString() {
		return "ProfileDto [memberseq=" + memberseq + ", photo=" + photo + ", school=" + school + ", major=" + major
				+ ", career=" + career + ", certificate=" + certificate + ", specialfield=" + specialfield + ", pmdate="
				+ pmdate + ", mentorcnt=" + mentorcnt + ", mentoaccstar=" + mentoaccstar + ", filechk=" + filechk
				+ ", profiledto=" + attachfiledto + "]";
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getSpecialfield() {
		return specialfield;
	}

	public void setSpecialfield(String specialfield) {
		this.specialfield = specialfield;
	}

	public String getPmdate() {
		return pmdate;
	}

	public void setPmdate(String pmdate) {
		this.pmdate = pmdate;
	}

	public String getMentorcnt() {
		return mentorcnt;
	}

	public void setMentorcnt(String mentorcnt) {
		this.mentorcnt = mentorcnt;
	}

	public String getMentoaccstar() {
		return mentoaccstar;
	}

	public void setMentoaccstar(String mentoaccstar) {
		this.mentoaccstar = mentoaccstar;
	}

	public String getFilechk() {
		return filechk;
	}

	public void setFilechk(String filechk) {
		this.filechk = filechk;
	}

	public AttachFileDto getAttachfiledto() {
		return attachfiledto;
	}

	public void setAttachfiledto(AttachFileDto attachfiledto) {
		this.attachfiledto = attachfiledto;
	}


	
	
	
	
}
