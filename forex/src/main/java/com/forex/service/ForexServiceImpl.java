package com.forex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.forex.dal.CurrencyDAL;
import com.forex.model.Currency;

@Service
public class ForexServiceImpl implements ForexService {

	@Autowired
	CurrencyDAL currencyDAL;

	@Autowired
	RestTemplate restTemplate;

	@Value("${forex.url}")
	private String forexUrl;

	@Override
	public List<Currency> getAllCurrency() {

		String apiurl = forexUrl + "INR";
		System.out.println("forex-url:" + apiurl);
		Currency currency = restTemplate.getForObject(apiurl, Currency.class);

		currencyDAL.addNewCurrency(currency);
		return currencyDAL.getAllCurrency();
	}

	@Override
	public Currency getCurrencyId(String currencyId) {

		return null;
	}

	@Override
	public Currency addNewCurrency(Currency currency) {

		return currencyDAL.addNewCurrency(currency);
	}

	@Override
	public Currency getCurrency(String localCode) {
		// construct forex url (third party)
		String apiurl = forexUrl + localCode;
		System.out.println("forex-url:" + apiurl);
		Currency currency = restTemplate.getForObject(apiurl, Currency.class);
		// TO SAVE IN MONGODB
		currencyDAL.addNewCurrency(currency);

		return currency;
	}

}
