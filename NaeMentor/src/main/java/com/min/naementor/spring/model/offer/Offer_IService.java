package com.min.naementor.spring.model.offer;

import java.util.List;
import java.util.Map;

import com.min.naementor.dtos.OfferDto;

public interface Offer_IService {
	/**
	 * 멘토가 멘티의 공고물에 제안서 입력
	 * @param dto(memberseq , boardseq , content , price)
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertOffer(OfferDto dto);
	/**
	 * 해당 글에 제안된 오퍼 모두 조회
	 * @param Map(boardseq/memberseq)
	 * @return OfferDto
	 */
	public OfferDto viewOffer(Map<String, String> map);
	/**
	 * 해당 글에 오퍼가 가능한지 확인
	 * @param map<boardseq,memberseq>
	 * @return boolean(true:입력가능)
	 */
	public boolean chkOffer(Map<String, String> map);
	
}
