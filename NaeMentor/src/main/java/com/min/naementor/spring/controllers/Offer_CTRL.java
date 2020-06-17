package com.min.naementor.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.naementor.dtos.OfferDto;
import com.min.naementor.spring.model.offer.Offer_IService;

@Controller
public class Offer_CTRL {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Offer_IService oservice;
	
	@RequestMapping(value = "/insertOffer.do", method = RequestMethod.POST)
	public void insertOffer(OfferDto dto) {
		log.info("Offer_CTRL insertOffer \t {}",dto);
	}
	
}
