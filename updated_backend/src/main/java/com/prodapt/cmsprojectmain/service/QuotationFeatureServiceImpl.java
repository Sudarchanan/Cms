package com.prodapt.cmsprojectmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.cmsprojectmain.entities.QuotationFeature;
import com.prodapt.cmsprojectmain.repositories.QuotationFeatureRepository;


@Service
public class QuotationFeatureServiceImpl  implements  QuotationFeatureService{
	
	@Autowired
	QuotationFeatureRepository repo;
	


	@Override
	public QuotationFeature addQuotationFeature(QuotationFeature quotationFeature) {
		return repo.save(quotationFeature);
	}

}
