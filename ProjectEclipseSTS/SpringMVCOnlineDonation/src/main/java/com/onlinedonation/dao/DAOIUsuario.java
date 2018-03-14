package com.onlinedonation.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlinedonation.bean.Usuario;

public interface DAOIUsuario {

	public void registerUsuario(Usuario usuario) throws Exception;

	public Integer checkUsuario(Usuario usuario) throws Exception;

	public List<Usuario> retrieveListResultSet(ResultSet resultSet) throws Exception;

}
