package com.min.naementor.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NaememberDto implements Serializable {
	                            
	
	private static final long serialVersionUID = -6310426503118340175L;
	
	private String memberseq     ;
	private String email         ;
	private String password      ;
	private String nickname      ;
	private String introduce     ;
	private String phone         ;
	private String birthday      ;
	private String gender        ;
	private String auth          ;
	private String userstatus    ;
	private String mentortier    ;
	private String logincnt      ;
	private String reportcnt     ;
	private String joindate      ;
	private String menteecnt     ;
	private String menteeaccstar ;
	private String lastaccess    ;
	private String byebye        ;
	private String target		 ;
	
	private ProfileDto profiledto;
	
	public NaememberDto() {
		// TODO Auto-generated constructor stub
	}

	

	public NaememberDto(String memberseq, String email, String password, String nickname, String introduce,
			String phone, String birthday, String gender, String auth, String userstatus, String mentortier,
			String logincnt, String reportcnt, String joindate, String menteecnt, String menteeaccstar,
			String lastaccess, String byebye, String target, ProfileDto profiledto) {
		super();
		this.memberseq = memberseq;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.introduce = introduce;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.auth = auth;
		this.userstatus = userstatus;
		this.mentortier = mentortier;
		this.logincnt = logincnt;
		this.reportcnt = reportcnt;
		this.joindate = joindate;
		this.menteecnt = menteecnt;
		this.menteeaccstar = menteeaccstar;
		this.lastaccess = lastaccess;
		this.byebye = byebye;
		this.target = target;
		this.profiledto = profiledto;
	}



	

	@Override
	public String toString() {
		return "NaememberDto [memberseq=" + memberseq + ", email=" + email + ", password=" + password + ", nickname="
				+ nickname + ", introduce=" + introduce + ", phone=" + phone + ", birthday=" + birthday + ", gender="
				+ gender + ", auth=" + auth + ", userstatus=" + userstatus + ", mentortier=" + mentortier
				+ ", logincnt=" + logincnt + ", reportcnt=" + reportcnt + ", joindate=" + joindate + ", menteecnt="
				+ menteecnt + ", menteeaccstar=" + menteeaccstar + ", lastaccess=" + lastaccess + ", byebye=" + byebye
				+ ", target=" + target + ", profiledto=" + profiledto + "]";
	}



	public String getMemberseq() {
		return memberseq;
	}



	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getIntroduce() {
		return introduce;
	}



	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAuth() {
		return auth;
	}



	public void setAuth(String auth) {
		this.auth = auth;
	}



	public String getUserstatus() {
		return userstatus;
	}



	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}



	public String getMentortier() {
		return mentortier;
	}



	public void setMentortier(String mentortier) {
		this.mentortier = mentortier;
	}



	public String getLogincnt() {
		return logincnt;
	}



	public void setLogincnt(String logincnt) {
		this.logincnt = logincnt;
	}



	public String getReportcnt() {
		return reportcnt;
	}



	public void setReportcnt(String reportcnt) {
		this.reportcnt = reportcnt;
	}



	public String getJoindate() {
		return joindate;
	}



	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}



	public String getMenteecnt() {
		return menteecnt;
	}



	public void setMenteecnt(String menteecnt) {
		this.menteecnt = menteecnt;
	}



	public String getMenteeaccstar() {
		return menteeaccstar;
	}



	public void setMenteeaccstar(String menteeaccstar) {
		this.menteeaccstar = menteeaccstar;
	}



	public String getLastaccess() {
		return lastaccess;
	}



	public void setLastaccess(String lastaccess) {
		this.lastaccess = lastaccess;
	}



	public String getByebye() {
		return byebye;
	}



	public void setByebye(String byebye) {
		this.byebye = byebye;
	}



	public String getTarget() {
		return target;
	}



	public void setTarget(String target) {
		this.target = target;
	}



	public ProfileDto getProfiledto() {
		return profiledto;
	}



	public void setProfiledto(ProfileDto profiledto) {
		this.profiledto = profiledto;
	}

	
}
