package com.min.naementor.spring.model.offer;

import java.util.List;

import com.min.naementor.dtos.OfferDto;

public interface Offer_IDao {
	/**
	 * 멘토가 멘티의 공고물에 제안서 입력
	 * @param dto(memberseq , boardseq , content , price)
	 * @return boolean(true: 입력 성공)
	 */
	public boolean insertOffer(OfferDto dto);
	/**
	 * 해당 글에 제안된 오퍼 모두 조회
	 * @param boardseq
	 * @return List<OfferDto>
	 */
	public List<OfferDto> viewOffer(String boardseq);
}
