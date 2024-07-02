package com.prodapt.cmsprojectmain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.cmsprojectmain.entities.Quotation;
import com.prodapt.cmsprojectmain.repositories.QuotationRepository;

@Service
public class QuotationServiceImpl implements QuotationService {

	@Autowired
	private QuotationRepository repo;

	@Override
	public Quotation addQuotation(Quotation quotation) {
		return repo.save(quotation);
	}

	@Override
	public List<Quotation> getAllQuotation() {
		List<Quotation> quotations = new ArrayList<>();
		repo.findAll().forEach(quotations::add);
		return quotations;
	}

}
