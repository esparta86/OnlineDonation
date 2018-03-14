package com.onlinedonation.service;

import java.util.List;

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Usuario;

public interface SIDonation {

	public void registerDonation(Donation donation) throws Exception;

	public List<Donation> retrieveAllDonation(Usuario usuario) throws Exception;

}
