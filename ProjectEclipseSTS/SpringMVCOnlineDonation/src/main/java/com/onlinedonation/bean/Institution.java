package com.onlinedonation.bean;

import java.util.Date;

public class Institution {

	private Integer idInstitution;
	private String nameIntitution;
	private Date registrationDate;
	private Country county;

	public Integer getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Integer idInstitution) {
		this.idInstitution = idInstitution;
	}

	public String getNameIntitution() {
		return nameIntitution;
	}

	public void setNameIntitution(String nameIntitution) {
		this.nameIntitution = nameIntitution;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Country getCounty() {
		return county;
	}

	public void setCounty(Country county) {
		this.county = county;
	}

}
