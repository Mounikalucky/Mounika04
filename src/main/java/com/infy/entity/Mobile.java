package com.infy.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mobile_id")
	private Integer mobileid;
	@Column(name="model_name")
	private String modelname;
	@Column(name="purchasing_date")
	private LocalDate purchasingDate;
	public Integer getMobileid() {
		return mobileid;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setMobileid(Integer mobileid) {
		this.mobileid = mobileid;
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
	public int hashCode() {
		return Objects.hash(mobileid, modelname, purchasingDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		return Objects.equals(getMobileid(), other.getMobileid()) && Objects.equals(modelname, other.modelname)
				 && Objects.equals(purchasingDate, other.purchasingDate);
		/*if (this.getMobileid() == null) {
			if (other.getMobileid() != null)
				return false;
		} else if (!this.getMobileid().equals(other.getMobileid())) {
			return false;
		}
		return true;*/
		

	}
}





