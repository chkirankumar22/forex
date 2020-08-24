package com.forex.dal;

import java.util.List;

import com.forex.model.Currency;

public interface CurrencyDAL {
	
	List<Currency> getAllCurrency();

	Currency getCurrencyId(String currencyId);

	Currency addNewCurrency(Currency currency);

}
