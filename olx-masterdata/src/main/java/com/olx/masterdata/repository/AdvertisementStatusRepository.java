package com.olx.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.masterdata.entity.AdvertisementStatus;

@Repository
public interface AdvertisementStatusRepository extends JpaRepository<AdvertisementStatus, Integer> {

}
