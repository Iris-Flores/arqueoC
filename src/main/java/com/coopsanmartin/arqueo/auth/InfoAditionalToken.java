package com.coopsanmartin.arqueo.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.coopsanmartin.arqueo.model.Usuario;
import com.coopsanmartin.arqueo.repository.IUsuarioService;

@Component
public class InfoAditionalToken implements TokenEnhancer{

	@Autowired
	IUsuarioService iUsuarioService;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = iUsuarioService.findByNombreUsuario(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		info.put("info adicional", "Bienvenido! : ".concat(authentication.getName()));
		
		info.put("nombres" , usuario.getNombres());
		info.put("apellidos" , usuario.getApellidos());
		info.put("ci" , usuario.getCi());
		
	    ((DefaultOAuth2AccessToken) accessToken) .setAdditionalInformation(info);
		
		return accessToken;
	}

}
