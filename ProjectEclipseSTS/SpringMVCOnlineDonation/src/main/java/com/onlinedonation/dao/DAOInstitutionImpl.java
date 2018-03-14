package com.onlinedonation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinedonation.bean.Institution;

@Repository
public class DAOInstitutionImpl implements DAOIInstitution {

	@Autowired
	private DataSource dataSourceMysql;

	@Override
	public List<Institution> retrieveAllInstitutions() throws Exception {
		String sql = "SELECT * FROM donation.institution";

		List<Institution> lista;
		Connection connection = null;
		ResultSet resulset = null;
		try {
			connection = dataSourceMysql.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resulset = preparedStatement.executeQuery();
			lista = retrieveListResultSet(resulset);
			preparedStatement.close();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	@Override
	public List<Institution> retrieveListResultSet(ResultSet rs) throws Exception {
		List<Institution> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Institution inst = new Institution();
				inst.setIdInstitution(rs.getInt("ID_INSTITUTION"));
				inst.setNameIntitution(rs.getString("NAME_INSTITUTION"));
				inst.setRegistrationDate(rs.getDate("REGISTRATION_DATE"));
				lista.add(inst);
			}

			return lista;
		} catch (Exception e) {
			throw e;
		}
	}

}
