package com.olx.masterdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.masterdata.entity.AdvertisementCategory;
import com.olx.masterdata.repository.AdvertisementCategoryRepository;
@Service
public class AdvertisementCategoryServiceImpl implements AdvertisementCategoryService {
@Autowired
private AdvertisementCategoryRepository categoryRepository;
	@Override
	public List<AdvertisementCategory> getAllAdvertiseCategories() {
		return categoryRepository.findAll();
	}
	@Override
	public AdvertisementCategory insertAdvertisementCategory(AdvertisementCategory advertisementCategory) {
		return categoryRepository.save(advertisementCategory);
	}

}
