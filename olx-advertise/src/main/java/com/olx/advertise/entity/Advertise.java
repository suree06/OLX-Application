package com.olx.advertise.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.olx.advertise.enums.Active;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=true)
public class Advertise extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private int categoryId;
	private int statusId;
	private double price;
	private String description;
	private byte[] photo;
	@Enumerated(EnumType.ORDINAL)
	private Active active;
	private String postedBy;
	private String userName;
}
