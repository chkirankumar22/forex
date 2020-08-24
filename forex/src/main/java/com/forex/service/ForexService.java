package com.forex.service;

import java.util.List;

import com.forex.model.Currency;


public interface ForexService {
	
	List<Currency> getAllCurrency();

	Currency getCurrencyId(String currencyId);

	Currency addNewCurrency(Currency currency);
	
	Currency getCurrency(String localCode);

}
