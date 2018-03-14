package com.onlinedonation.service;

import com.onlinedonation.bean.Usuario;

public interface SIUsuario {

	public void registerUsuario(Usuario usuario) throws Exception;

	public Integer checkUsuario(Usuario usuario) throws Exception;

}
