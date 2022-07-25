package com.infy.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

public class MobileDTO {
	
	private Integer mobileId;
	private String modelname;
	private LocalDate purchasingDate;
	 
	
 	public MobileDTO(Integer mobileId, String modelname, LocalDate purchasingDate) {
		super();
		this.mobileId = mobileId;
		this.modelname = modelname;
		this.purchasingDate = purchasingDate;
	}
 	public MobileDTO() {
		super();
		// TODO Auto-generated constructor stub
 	}
 	
	public Integer getMobileId() {
		return mobileId;
	}
	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public LocalDate getPurchasingDate() {
		return purchasingDate;
	}
	public void setPurchasingDate(LocalDate purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
	@Override
	public String toString() {
		return "MobileDTO [mobileId=" + mobileId + ", modelname=" + modelname + ", purchasingDate=" + purchasingDate
				+ "]";
	}

}
