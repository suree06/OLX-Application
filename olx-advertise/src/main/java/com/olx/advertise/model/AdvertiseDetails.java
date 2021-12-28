package com.olx.advertise.model;

import java.time.LocalDateTime;

import com.olx.advertise.enums.Active;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseDetails {
	private int id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String userName;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private String status;
	private Active active;
	private String postedBy;
}
