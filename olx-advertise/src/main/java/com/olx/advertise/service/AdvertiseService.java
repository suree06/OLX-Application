package com.olx.advertise.service;

import com.olx.advertise.entity.Advertise;

public interface AdvertiseService {
	Advertise postAdvertise(Advertise advertise);
	Advertise updateAdvertise(int id, Advertise advertise);
	Advertise getAdvertise(int postId);
	boolean removeAdvertise(int id);

}
