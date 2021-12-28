package com.olx.masterdata.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.masterdata.entity.AdvertisementCategory;
import com.olx.masterdata.entity.AdvertisementStatus;
import com.olx.masterdata.service.AdvertisementCategoryService;
import com.olx.masterdata.service.AdvertisementStatusService;

@RestController
@RequestMapping("/master-data")
public class MasterDataResource {
	@Autowired
	private AdvertisementCategoryService categoryService;
	@Autowired
	private AdvertisementStatusService statusService;
	
	@GetMapping("/category")
	public List<AdvertisementCategory> getAllAdvertiseCategories() {
		return categoryService.getAllAdvertiseCategories();
	}

	@GetMapping("/status")
	public List<AdvertisementStatus> getAllAdvertiseStatus() {
		return statusService.getAllAdvertiseStatuses();
	}
}
