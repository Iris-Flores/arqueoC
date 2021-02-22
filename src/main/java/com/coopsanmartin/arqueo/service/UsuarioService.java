package com.coopsanmartin.arqueo.service;



import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopsanmartin.arqueo.model.Usuario;
import com.coopsanmartin.arqueo.repository.IUsuarioService;
import com.coopsanmartin.arqueo.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService,UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(username);
		
		if(usuario == null) {
			logger.error("Error em el login: no existe el usuario en el sistema '" + username+ "' en el sistema");
			throw new UsernameNotFoundException("Error en el login: no existe el usurio '"+ username + "' en ele sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getNombreRol())).peek(authority -> logger.info("Rol: "+ authority.getAuthority())).collect(Collectors.toList());
		
		return new User(usuario.getNombreUsuario(), usuario.getPassword(), usuario.getEstado(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByNombreUsuario(String nombreUsuario) {
		
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	

}
