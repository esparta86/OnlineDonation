package com.onlinedonation.service;

import java.util.List;

import com.onlinedonation.bean.Institution;

public interface SIInstitution {

	public List<Institution> retrieveAllInstitution() throws Exception;

}
