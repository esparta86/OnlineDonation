package com.onlinedonation.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Usuario;

public interface DAOIDonation {

	public void registerDonation(Donation donation) throws Exception;

	public List<Donation> retrieveAllDonation(Usuario usuario) throws Exception;

	public List<Donation> retrieveListResultSet(ResultSet resultSet) throws Exception;

}
