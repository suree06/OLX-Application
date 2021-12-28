package com.olx.masterdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.olx.masterdata.entity.AdvertisementCategory;
import com.olx.masterdata.entity.AdvertisementStatus;
import com.olx.masterdata.service.AdvertisementCategoryService;
import com.olx.masterdata.service.AdvertisementStatusService;

@SpringBootApplication
@EnableEurekaClient
public class OlxMasterdataApplication implements ApplicationRunner {
	@Autowired
	private AdvertisementCategoryService categoryService;
	@Autowired
	private AdvertisementStatusService statusService;

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterdataApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<AdvertisementCategory> categoryList = new ArrayList<AdvertisementCategory>();
		categoryList.add(new AdvertisementCategory(1,"Furniture","Holds all Furniture"));
		categoryList.add(new AdvertisementCategory(2,"Cars","Holds all Cars"));
		categoryList.add(new AdvertisementCategory(3,"Mobiles","Holds all Mobiles"));
		for (Iterator<AdvertisementCategory> iterator = categoryList.iterator(); iterator.hasNext();) {
			AdvertisementCategory advertisementCategory2 = (AdvertisementCategory) iterator.next();
			categoryService.insertAdvertisementCategory(advertisementCategory2);
		}
		
		List<AdvertisementStatus> statusList = new ArrayList<AdvertisementStatus>();
		statusList.add(new AdvertisementStatus(1,"OPEN"));
		statusList.add(new AdvertisementStatus(2,"CLOSED"));
		for (Iterator<AdvertisementStatus> iterator = statusList.iterator(); iterator.hasNext();) {
			AdvertisementStatus advertisementStatus = (AdvertisementStatus) iterator.next();
			System.out.println("AdvertisementStatus: "+advertisementStatus.getId()+" : "+advertisementStatus.getStatus());
			statusService.insertAdvertisementStatus(advertisementStatus);
		}
	}

}
