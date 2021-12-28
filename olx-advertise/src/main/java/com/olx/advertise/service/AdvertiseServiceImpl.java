package com.olx.advertise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.advertise.entity.Advertise;
import com.olx.advertise.repository.AdvertiseRepository;
@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	@Autowired
	private AdvertiseRepository advertiseRepository;

	@Override
	public Advertise postAdvertise(Advertise advertise) {
		return advertiseRepository.save(advertise);
	}

	@Override
	public Advertise updateAdvertise(int id, Advertise advertise) {
		Advertise advertise1 = getAdvertise(id);
		advertise1.setTitle(advertise.getTitle());
		advertise1.setPrice(advertise.getPrice());
		advertise1.setCategoryId(advertise.getCategoryId());
		advertise1.setStatusId(advertise.getStatusId());
		advertise1.setDescription(advertise.getDescription());
		return advertiseRepository.save(advertise1);
	}

	@Override
	public Advertise getAdvertise(int postId) {
		return advertiseRepository.getById(postId);
	}

	@Override
	public boolean removeAdvertise(int id) {
		advertiseRepository.deleteById(id);
		return !advertiseRepository.existsById(id);
	}
}
