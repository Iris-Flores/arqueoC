package com.coopsanmartin.arqueo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopsanmartin.arqueo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	
	
}
