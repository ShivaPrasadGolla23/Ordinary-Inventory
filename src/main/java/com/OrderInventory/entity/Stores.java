package com.OrderInventory.entity;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Stores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private String webAddress;
	private String physicalAddress;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String logoMimeType;
	private String logoFilename;
	private String logoCharset;
	private Date logoLastUpdated;
}
