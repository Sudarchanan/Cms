package com.prodapt.cmsprojectmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.cmsprojectmain.entities.QuotationParameter;
import com.prodapt.cmsprojectmain.repositories.QuotationParameterRepository;

@Service
public class QuotationParameterServiceImpl implements QuotationParameterService {

	@Autowired
	QuotationParameterRepository repo;

	@Override
	public QuotationParameter addQuotationParameter(QuotationParameter quotationParameter) {

		return repo.save(quotationParameter);
	}

}
