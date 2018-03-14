package com.onlinedonation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlinedonation.bean.Donation;
import com.onlinedonation.bean.Usuario;

@Repository
public class DAODonationImpl implements DAOIDonation {

	@Autowired
	private DataSource dataSourceMysql;

	@Override
	public void registerDonation(Donation donation) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Donation> retrieveAllDonation(Usuario usuario) throws Exception {
		String sql = "SELECT * FROM donation.donation WHERE IDUSUARIO=" + usuario.getIdUsuario() + " "
				+ "    ORDER BY DONATION_DATE DESC;";

		List<Donation> lista;
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
	public List<Donation> retrieveListResultSet(ResultSet rs) throws Exception {

		List<Donation> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Donation dona = new Donation();
				dona.setIdDonation(rs.getInt("IDDONATION"));
				dona.setIdUsuario(rs.getInt("IDUSUARIO"));
				dona.setIdInstitution(rs.getInt("ID_INSTITUTION"));
				dona.setAmount(rs.getBigDecimal("AMOUNT"));
				dona.setCreditCard(rs.getString("CREDITCARD"));
				dona.setTypeCreditCard(rs.getString("TYPE_CREDIT_CARD").charAt(0));
				dona.setDonationDate(rs.getDate("DONATION_DATE"));
				lista.add(dona);
			}

			return lista;
		} catch (Exception e) {
			throw e;
		}

	}

}
