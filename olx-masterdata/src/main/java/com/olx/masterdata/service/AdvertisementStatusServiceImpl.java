package com.olx.masterdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.olx.masterdata.entity.AdvertisementStatus;
import com.olx.masterdata.repository.AdvertisementStatusRepository;
@Repository
public class AdvertisementStatusServiceImpl implements AdvertisementStatusService {
@Autowired
private AdvertisementStatusRepository statusRepository;
	@Override
	public List<AdvertisementStatus> getAllAdvertiseStatuses() {
		return statusRepository.findAll();
	}
	@Override
	public AdvertisementStatus insertAdvertisementStatus(AdvertisementStatus advertisementStatus) {
		return statusRepository.save(advertisementStatus);
	}

}
