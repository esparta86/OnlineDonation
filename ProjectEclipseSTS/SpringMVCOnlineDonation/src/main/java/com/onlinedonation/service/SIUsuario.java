package com.onlinedonation.service;

import com.onlinedonation.bean.Usuario;

public interface SIUsuario {

	public void registerUsuario(Usuario usuario) throws Exception;

	public Boolean checkUsuario(Usuario usuario) throws Exception;

}
