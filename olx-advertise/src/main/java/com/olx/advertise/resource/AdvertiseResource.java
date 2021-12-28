package com.olx.advertise.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.advertise.client.MasterDataClient;
import com.olx.advertise.entity.Advertise;
import com.olx.advertise.exception.AdvertiseNotFoundException;
import com.olx.advertise.model.AdvertiseDetails;
import com.olx.advertise.service.AdvertiseService;
import com.olx.advertise.vo.AdvertisementCategory;
import com.olx.advertise.vo.AdvertisementStatus;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/advertise")
public class AdvertiseResource {
	@Autowired
	private MasterDataClient masterDataClient;
	@Autowired
	private AdvertiseService advertiseService;

	@PostMapping("/")
	@Retry(name="post-advertisement", fallbackMethod="handlePostError")
	public AdvertiseDetails postAdvertise(@RequestBody Advertise advertise) {
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		List<AdvertisementCategory> advCatList = masterDataClient.getAllAdvertisementCategory();
		AdvertisementCategory advertisementCategory = getAdvertisementCategory(advertise.getCategoryId(), advCatList);
		if (advertisementCategory != null && advertisementCategory.getName() != null) {
			advertiseDetails.setCategory(advertisementCategory.getName());
		}
		List<AdvertisementStatus> advStatusList = masterDataClient.getAllAdvertiseStatus();

		if (advertisementCategory != null && advertisementCategory.getName() != null) {
			advertiseDetails.setCategory(advertisementCategory.getName());
		}
		AdvertisementStatus advertisementStatus = getAdvertisementStatus(advertise.getStatusId(), advStatusList);
		if (advertisementStatus != null && advertisementStatus.getStatus() != null) {
			advertiseDetails.setStatus(advertisementStatus.getStatus());
		}
		Advertise advertiseResponse = advertiseService.postAdvertise(advertise);
		if (advertiseResponse != null) {
			advertiseDetails.setId(advertiseResponse.getId());
			advertiseDetails.setTitle(advertiseResponse.getTitle());
			advertiseDetails.setPrice(advertiseResponse.getPrice());
			advertiseDetails.setDescription(advertiseResponse.getDescription());
			advertiseDetails.setUserName(advertiseResponse.getUserName());
			advertiseDetails.setCreatedDate(advertiseResponse.getCreatedDate());
			advertiseDetails.setModifiedDate(advertiseResponse.getModifiedDate());
			advertiseDetails.setActive(advertiseResponse.getActive());
			advertiseDetails.setPostedBy(advertiseResponse.getPostedBy());
		}
		return advertiseDetails;
	}

	@PutMapping("/{id}")
	@Retry(name="update-advertisement",fallbackMethod="handleUpdateError")
	public AdvertiseDetails updateAdvertise(@PathVariable int id, @RequestBody Advertise advertise) {
		/* System.out.println("UPDATE:::::::::::::::::::::::::::"+advertiseService.getAdvertise(id));
		if(advertiseService.getAdvertise(id) == null)throw new AdvertiseNotFoundException(); */
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		List<AdvertisementCategory> advCatList = masterDataClient.getAllAdvertisementCategory();
		AdvertisementCategory advertisementCategory = getAdvertisementCategory(advertise.getCategoryId(), advCatList);
		if (advertisementCategory != null && advertisementCategory.getName() != null) {
			advertiseDetails.setCategory(advertisementCategory.getName());
		}
		List<AdvertisementStatus> advStatusList = masterDataClient.getAllAdvertiseStatus();

		if (advertisementCategory != null && advertisementCategory.getName() != null) {
			advertiseDetails.setCategory(advertisementCategory.getName());
		}
		AdvertisementStatus advertisementStatus = getAdvertisementStatus(advertise.getStatusId(), advStatusList);
		if (advertisementStatus != null && advertisementStatus.getStatus() != null) {
			advertiseDetails.setStatus(advertisementStatus.getStatus());
		}
		Advertise advertiseResponse = advertiseService.updateAdvertise(id, advertise);
		if (advertiseResponse != null) {
			advertiseDetails.setId(advertiseResponse.getId());
			advertiseDetails.setTitle(advertiseResponse.getTitle());
			advertiseDetails.setPrice(advertiseResponse.getPrice());
			advertiseDetails.setDescription(advertiseResponse.getDescription());
			advertiseDetails.setUserName(advertiseResponse.getUserName());
			advertiseDetails.setCreatedDate(advertiseResponse.getCreatedDate());
			advertiseDetails.setModifiedDate(advertiseResponse.getModifiedDate());
			advertiseDetails.setActive(advertiseResponse.getActive());
			advertiseDetails.setPostedBy(advertiseResponse.getPostedBy());
		}
		return advertiseDetails;
	}

	@GetMapping("/{postId}")
	@Retry(name="get-advertisement",fallbackMethod="handleGetError")
	public AdvertiseDetails getAdvertise(@PathVariable int postId) {
		/*System.out.println("GET:::::::::::::::::::::::::::"+advertiseService.getAdvertise(postId));
		if(advertiseService.getAdvertise(postId) == null)throw new AdvertiseNotFoundException(); */		
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		Advertise advertiseResponse = advertiseService.getAdvertise(postId);
		if (advertiseResponse != null) {
			advertiseDetails.setId(advertiseResponse.getId());
			advertiseDetails.setTitle(advertiseResponse.getTitle());
			advertiseDetails.setPrice(advertiseResponse.getPrice());
			advertiseDetails.setDescription(advertiseResponse.getDescription());
			advertiseDetails.setUserName(advertiseResponse.getUserName());
			advertiseDetails.setCreatedDate(advertiseResponse.getCreatedDate());
			advertiseDetails.setModifiedDate(advertiseResponse.getModifiedDate());
			advertiseDetails.setActive(advertiseResponse.getActive());
			advertiseDetails.setPostedBy(advertiseResponse.getPostedBy());

			List<AdvertisementCategory> advCatList = masterDataClient.getAllAdvertisementCategory();
			AdvertisementCategory advertisementCategory = getAdvertisementCategory(advertiseResponse.getCategoryId(),
					advCatList);
			if (advertisementCategory != null && advertisementCategory.getName() != null) {
				advertiseDetails.setCategory(advertisementCategory.getName());
			}
			List<AdvertisementStatus> advStatusList = masterDataClient.getAllAdvertiseStatus();

			if (advertisementCategory != null && advertisementCategory.getName() != null) {
				advertiseDetails.setCategory(advertisementCategory.getName());
			}
			AdvertisementStatus advertisementStatus = getAdvertisementStatus(advertiseResponse.getStatusId(),
					advStatusList);
			if (advertisementStatus != null && advertisementStatus.getStatus() != null) {
				advertiseDetails.setStatus(advertisementStatus.getStatus());
			}
		}
		return advertiseDetails;
	}

	@DeleteMapping("/{id}")
	public boolean removeAdvertise(@PathVariable int id) {
		/* System.out.println("REMOVE:::::::::::::::::::::::::::"+advertiseService.getAdvertise(id));
		if(advertiseService.getAdvertise(id) == null)throw new AdvertiseNotFoundException(); */		
		return advertiseService.removeAdvertise(id);
	}

	private AdvertisementCategory getAdvertisementCategory(int i, List<AdvertisementCategory> advCatList) {
		System.out.println("AadvertisementCategory not found: ");
		if (advCatList != null && !advCatList.isEmpty()) {
			for (AdvertisementCategory advertisementCategory : advCatList) {
				if (advertisementCategory.getId() == i) {
					System.out.println("AadvertisementCategory found: " + advertisementCategory.getId() + " : "
							+ advertisementCategory.getName());
					return advertisementCategory;
				} else {
					System.out.println("AadvertisementCategory not found: ");
				}
			}
		}
		return null;
	}

	private AdvertisementStatus getAdvertisementStatus(int i, List<AdvertisementStatus> advStatusList) {
		if (advStatusList != null && !advStatusList.isEmpty()) {
			for (AdvertisementStatus advertisementStatus : advStatusList) {
				if (advertisementStatus.getId() == i) {
					return advertisementStatus;
				}
			}
		}
		return null;
	}

	public AdvertiseDetails handlePostError(Advertise advertise, Exception exception) {
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		return advertiseDetails;
	}	

	public AdvertiseDetails handleUpdateError(int id, Advertise advertise, Exception exception) {
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		return advertiseDetails;
	}
	
	public AdvertiseDetails handleGetError(int id, Exception exception) {
		AdvertiseDetails advertiseDetails = new AdvertiseDetails();
		return advertiseDetails;
	}

}
