package com.onlinedonation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinedonation.bean.Usuario;
import com.onlinedonation.dao.DAOIUsuario;

@Service
public class ServiceUsuarioImp implements SIUsuario {

	@Autowired
	private DAOIUsuario daoiUsuario;

	@Override
	public void registerUsuario(Usuario usuario) throws Exception {
		try {
			daoiUsuario.registerUsuario(usuario);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public Boolean checkUsuario(Usuario usuario) throws Exception {
		try {
			return daoiUsuario.checkUsuario(usuario);
		} catch (Exception e) {
			throw e;
		}
	}

}
