package com.onlinedonation.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlinedonation.bean.Institution;

public interface DAOIInstitution {

	public List<Institution> retrieveAllInstitutions() throws Exception;

	public List<Institution> retrieveListResultSet(ResultSet resultSet) throws Exception;

}
