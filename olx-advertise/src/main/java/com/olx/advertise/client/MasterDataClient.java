package com.olx.advertise.client;

import java.util.List;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.olx.advertise.vo.AdvertisementCategory;
import com.olx.advertise.vo.AdvertisementStatus;


@FeignClient("OLX-MASTERDATA")
public interface MasterDataClient {
	
	@GetMapping("/master-data/category")
	@LoadBalanced
public List<AdvertisementCategory> getAllAdvertisementCategory();

	@GetMapping("/master-data/status")
	@LoadBalanced
public  List<AdvertisementStatus> getAllAdvertiseStatus();
}
