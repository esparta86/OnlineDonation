package com.onlinedonation.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlinedonation.bean.Usuario;

@Repository
public class DAOUsuarioImpl implements DAOIUsuario {

	@Autowired
	private DataSource dataSourceMysql;

	private JdbcTemplate jdbcTemplate;

	@Override
	public void registerUsuario(Usuario usuario) throws Exception {
		String sql = "INSERT INTO usuario(idusuario,username,password,registrationdate)" + " VALUES(?,?,?,?)";
		try {
			jdbcTemplate = new JdbcTemplate(dataSourceMysql);
			jdbcTemplate.update(sql, new Object[] { usuario.getIdUsuario(), usuario.getUserName(),
					usuario.getPassword(), usuario.getRegistrationDate() });
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Register user error :" + e.getMessage());
		} finally {

		}
	}

	@Override
	public Boolean checkUsuario(Usuario usuario) throws Exception {
		String sql = "select idusuario from donation.usuario where username='" + usuario.getUserName() + "' and "
				+ " MD5('" + usuario.getPassword() + "') = password ";
		try {
			jdbcTemplate = new JdbcTemplate(dataSourceMysql);
			Integer idUsuario = jdbcTemplate.queryForObject(sql, Integer.class);
			return idUsuario != null ? Boolean.TRUE : Boolean.FALSE;

		} catch (EmptyResultDataAccessException e) {
			return Boolean.FALSE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
		}

	}

	@Override
	public List<Usuario> retrieveListResultSet(ResultSet resultSet) throws Exception {
		List<Usuario> lista = new ArrayList<>();
		try {
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultSet.getInt("IDUSUARIO"));
				usuario.setUserName(resultSet.getString("USERNAME"));
				usuario.setPassword(resultSet.getString("PASSWORD"));
				usuario.setRegistrationDate(resultSet.getDate("REGISTRATIONDATE"));

				lista.add(usuario);
			}

			return lista;
		} catch (Exception e) {
			throw e;
		}
	}

}
