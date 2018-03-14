package com.onlinedonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Usuario;
import com.onlinedonation.dao.DAOIDonation;

@Service
public class ServiceDonationImp implements SIDonation {

	@Autowired
	private DAOIDonation daoiDonation;

	@Override
	public void registerDonation(Donation donation) throws Exception {
		try {
			daoiDonation.registerDonation(donation);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Donation> retrieveAllDonation(Usuario usuario) throws Exception {
		try {
			return daoiDonation.retrieveAllDonation(usuario);
		} catch (Exception e) {
			throw e;
		}
	}

}
