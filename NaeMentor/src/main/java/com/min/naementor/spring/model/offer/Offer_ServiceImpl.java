package com.min.naementor.spring.model.offer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.naementor.dtos.OfferDto;

@Service
public class Offer_ServiceImpl implements Offer_IService{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Offer_IDao dao;
	
	@Override
	public boolean insertOffer(OfferDto dto) {
		log.info("Offer_ServiceImpl insertOffer {}",dto);
		return dao.insertOffer(dto);
	}

	@Override
	public List<OfferDto> viewOffer(String boardseq) {
		log.info("Offer_ServiceImpl viewOffer {}",boardseq);
		return dao.viewOffer(boardseq);
	}

}
