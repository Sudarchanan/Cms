package com.prodapt.cmsprojectmain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.cmsprojectmain.entities.Product;
import com.prodapt.cmsprojectmain.entities.Quotation;
import com.prodapt.cmsprojectmain.entities.QuotationFeature;
import com.prodapt.cmsprojectmain.entities.QuotationParameter;
import com.prodapt.cmsprojectmain.entities.QuotationProduct;
import com.prodapt.cmsprojectmain.exceptions.ProductNotFoundException;
import com.prodapt.cmsprojectmain.service.ProductService;
import com.prodapt.cmsprojectmain.service.QuotationFeatureService;
import com.prodapt.cmsprojectmain.service.QuotationParameterService;
import com.prodapt.cmsprojectmain.service.QuotationProductServices;
import com.prodapt.cmsprojectmain.service.QuotationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "InternetService Manager API")
public class ManagerController {

	@Autowired
	private ProductService productService;

	@Autowired
	private QuotationService quotationService;
	
	@Autowired
	private QuotationProductServices quotationProductService;
	
	@Autowired
	private QuotationFeatureService quotationFeatureService;
	
	@Autowired
	private QuotationParameterService quotationParameterService;

	@Operation(summary = "Get Product By Name")
	@GetMapping("/getproductbyname")
	public ResponseEntity<Product> getProductByName(@RequestParam("name") String name) throws ProductNotFoundException {
		Product product = productService.getProductByName(name);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@Operation(summary = "Get Product By ID")
	@GetMapping("/getproductbyid")
	public ResponseEntity<Product> getProductById(@RequestParam("id") Long productId) throws ProductNotFoundException {

		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@Operation(summary = "Get All Products")
	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@Operation(summary = "Add quotation")
	@PostMapping("/addquotation")
	 public ResponseEntity<Quotation> addQuotation(@RequestBody Quotation quotation) {
        Quotation savedQuotation = quotationService.addQuotation(quotation);
        return new ResponseEntity<Quotation>(savedQuotation, HttpStatus.CREATED);
    }
	@Operation(summary = "Add quotation Product")
	@PostMapping("/addquotationproduct")
	public ResponseEntity<QuotationProduct> addQuotationProduct(@RequestBody QuotationProduct quotationProduct) {
		QuotationProduct savedQuotationProduct = quotationProductService.addQuotationProduct(quotationProduct);
		return new ResponseEntity<QuotationProduct>(savedQuotationProduct, HttpStatus.CREATED);
	}
	@Operation(summary = "Add quotation Feature")
	@PostMapping("/addquotationfeature")
	public ResponseEntity<QuotationFeature> addQuotationFeature(@RequestBody QuotationFeature quotationFeature) {
		QuotationFeature savedQuotationFeature = quotationFeatureService.addQuotationFeature(quotationFeature);
		return new ResponseEntity<QuotationFeature>(savedQuotationFeature, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Add quotation Parameter")
	@PostMapping("/addquotationparameter")
	public ResponseEntity<QuotationParameter> addQuotationParameter(@RequestBody QuotationParameter quotationParameter){
		QuotationParameter savedQuotationParameter = quotationParameterService.addQuotationParameter(quotationParameter);
		return new ResponseEntity<QuotationParameter>(savedQuotationParameter, HttpStatus.CREATED);
		
	}

}