package com.prodapt.cmsprojectmain.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.cmsprojectmain.entities.Features;
import com.prodapt.cmsprojectmain.exceptions.FeatureNotFoundException;
import com.prodapt.cmsprojectmain.repositories.FeatureRepository;

@Service
public class FeatureServiceImpl implements FeatureService {

	private static final Logger loggers = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private FeatureRepository repo;

	@Override
	public Features createFeature(Features feature) {

		return repo.save(feature);
	}

	@Override
	public String deleteFeatureById(Long featureId) throws FeatureNotFoundException {
		Optional<Features> deletedFeature = repo.findById(featureId);
		if (deletedFeature.isPresent()) {
			repo.deleteById(featureId);
			loggers.info("Feature with ID " + featureId + " has been deleted.");
			return "Feature deleted successfully";
		} else {
			loggers.info("Feature with ID " + featureId + " does not exist in the record.");
			throw new FeatureNotFoundException();
		}
	}


}
