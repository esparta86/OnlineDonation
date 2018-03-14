package com.onlinedonation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedonation.bean.Institution;
import com.onlinedonation.dao.DAOIInstitution;

@Service
public class ServiceInstitutionImp implements SIInstitution {

	@Autowired
	private DAOIInstitution daoiInstitution;

	@Override
	public List<Institution> retrieveAllInstitution() throws Exception {
		try {
			return daoiInstitution.retrieveAllInstitutions();
		} catch (Exception e) {
			throw e;
		}
	}

}
