package com.forex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.forex.dal.CurrencyDAL;
import com.forex.model.Currency;
import com.forex.service.ForexService;

@RestController
@RequestMapping("/forex")
public class ForexController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CurrencyDAL currencyDAL;

	@Autowired
	ForexService forexService;

	@RequestMapping(value = "/lastest/{localCode}", method = RequestMethod.GET)
	public Currency getCurrency(@PathVariable String localCode) {

		return forexService.getCurrency(localCode);
	}

}
