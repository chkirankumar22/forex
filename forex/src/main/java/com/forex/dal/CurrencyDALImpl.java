package com.forex.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forex.model.Currency;

@Repository
public class CurrencyDALImpl implements CurrencyDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Currency> getAllCurrency() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Currency.class);
	}

	@Override
	public Currency getCurrencyId(String currencyId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(currencyId));
		return mongoTemplate.findOne(query, Currency.class);
	}

	@Override
	public Currency addNewCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(currency);
	}

}
