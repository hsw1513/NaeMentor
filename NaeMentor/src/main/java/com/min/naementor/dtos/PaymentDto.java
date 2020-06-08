package com.min.naementor.dtos;

import java.io.Serializable;

public class PaymentDto implements Serializable {

	private static final long serialVersionUID = 2554913786950393174L;
	
	private String boardseq;
	private String menteepay;
	private String menteepaytime;
	private String paystatus;
	private String refundno;
	private String paidTS;
	private String mentorpay;
	private String paytoken;
	private String memberseq;
	public PaymentDto() {
	}
	public PaymentDto(String boardseq, String menteepay, String menteepaytime, String paystatus, String refundno,
			String paidTS, String mentorpay, String paytoken, String memberseq) {
		super();
		this.boardseq = boardseq;
		this.menteepay = menteepay;
		this.menteepaytime = menteepaytime;
		this.paystatus = paystatus;
		this.refundno = refundno;
		this.paidTS = paidTS;
		this.mentorpay = mentorpay;
		this.paytoken = paytoken;
		this.memberseq = memberseq;
	}
	@Override
	public String toString() {
		return "paymentDto [boardseq=" + boardseq + ", menteepay=" + menteepay + ", menteepaytime=" + menteepaytime
				+ ", paystatus=" + paystatus + ", refundno=" + refundno + ", paidTS=" + paidTS + ", mentorpay="
				+ mentorpay + ", paytoken=" + paytoken + ", memberseq=" + memberseq + "]";
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	public String getMenteepay() {
		return menteepay;
	}
	public void setMenteepay(String menteepay) {
		this.menteepay = menteepay;
	}
	public String getMenteepaytime() {
		return menteepaytime;
	}
	public void setMenteepaytime(String menteepaytime) {
		this.menteepaytime = menteepaytime;
	}
	public String getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}
	public String getRefundno() {
		return refundno;
	}
	public void setRefundno(String refundno) {
		this.refundno = refundno;
	}
	public String getPaidTS() {
		return paidTS;
	}
	public void setPaidTS(String paidTS) {
		this.paidTS = paidTS;
	}
	public String getMentorpay() {
		return mentorpay;
	}
	public void setMentorpay(String mentorpay) {
		this.mentorpay = mentorpay;
	}
	public String getPaytoken() {
		return paytoken;
	}
	public void setPaytoken(String paytoken) {
		this.paytoken = paytoken;
	}
	public String getMemberseq() {
		return memberseq;
	}
	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	
	
}
