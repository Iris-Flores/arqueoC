package com.coopsanmartin.arqueo.repository;

import com.coopsanmartin.arqueo.model.Usuario;

public interface IUsuarioService {
	public Usuario findByNombreUsuario(String nombreUsuario);
}
