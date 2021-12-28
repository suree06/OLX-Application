package com.olx.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.masterdata.entity.AdvertisementCategory;
@Repository
public interface AdvertisementCategoryRepository extends JpaRepository<AdvertisementCategory, Integer> {

}
