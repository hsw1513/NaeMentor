package com.min.naementor.dtos;

import java.io.Serializable;

public class OfferDto implements Serializable{

	private static final long serialVersionUID = 3496356457025603587L;
	private String memberseq    ;
	private String boardseq     ;
	private String content      ;
	private String price        ;
	
	public OfferDto() {
	}

	public OfferDto(String memberseq, String boardseq, String content, String price) {
		super();
		this.memberseq = memberseq;
		this.boardseq = boardseq;
		this.content = content;
		this.price = price;
	}

	@Override
	public String toString() {
		return "OfferDto [memberseq=" + memberseq + ", boardseq=" + boardseq + ", content=" + content + ", price="
				+ price + "]";
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
