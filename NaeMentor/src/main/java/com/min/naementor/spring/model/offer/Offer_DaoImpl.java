package com.min.naementor.spring.model.offer;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.naementor.dtos.OfferDto;

@Repository
public class Offer_DaoImpl implements Offer_IDao{
	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.min.naementor.offer.";
	
	@Override
	public boolean insertOffer(OfferDto dto) {
		return session.insert(NS+"insertOffer", dto)>0?true:false;
	}

	@Override
	public List<OfferDto> viewOffer(String boardseq) {
		return session.selectList(NS+"viewOffer", boardseq);
	}

}
