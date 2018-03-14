package com.onlinedonation.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Donation {

	private Integer idDonation;
	private Usuario usuario;
	private BigDecimal amount;
	private String creditCard;
	private char typeCreditCard;
	private Date donationDate;
	private Institution institution;

	private Integer idUsuario;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Integer idInstitution) {
		this.idInstitution = idInstitution;
	}

	private Integer idInstitution;

	public Integer getIdDonation() {
		return idDonation;
	}

	public void setIdDonation(Integer idDonation) {
		this.idDonation = idDonation;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public char getTypeCreditCard() {
		return typeCreditCard;
	}

	public void setTypeCreditCard(char typeCreditCard) {
		this.typeCreditCard = typeCreditCard;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}
