package com.olx.masterdata.service;

import java.util.List;

import com.olx.masterdata.entity.AdvertisementStatus;

public interface AdvertisementStatusService {

	List<AdvertisementStatus> getAllAdvertiseStatuses();
	AdvertisementStatus insertAdvertisementStatus(AdvertisementStatus advertisementStatus);

}
