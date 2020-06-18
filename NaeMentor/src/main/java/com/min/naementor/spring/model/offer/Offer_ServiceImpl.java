package com.min.naementor.spring.model.offer;

import java.util.List;
import java.util.Map;

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
	public OfferDto viewOffer(Map<String, String> map) {
		log.info("Offer_ServiceImpl viewOffer {}",map);
		return dao.viewOffer(map);
	}

	@Override
	public boolean chkOffer(Map<String, String> map) {
		log.info("Offer_ServiceImpl chkOffer {}",map);
		return dao.chkOffer(map);
	}

}
