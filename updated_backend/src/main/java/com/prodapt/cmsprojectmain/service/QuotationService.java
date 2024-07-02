package com.prodapt.cmsprojectmain.service;

import java.util.List;

import com.prodapt.cmsprojectmain.entities.Quotation;

public interface QuotationService {

	public Quotation addQuotation(Quotation quotation);

	public List<Quotation> getAllQuotation();

}