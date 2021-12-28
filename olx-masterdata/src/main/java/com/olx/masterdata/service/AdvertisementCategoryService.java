package com.olx.masterdata.service;

import java.util.List;

import com.olx.masterdata.entity.AdvertisementCategory;

public interface AdvertisementCategoryService {

	List<AdvertisementCategory> getAllAdvertiseCategories();
	AdvertisementCategory insertAdvertisementCategory(AdvertisementCategory advertisementCategory);

}
