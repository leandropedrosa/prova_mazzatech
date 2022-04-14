package br.com.mazzatech.portal.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.mazzatech.portal.model.Usuario;

@Component
@Scope("session")
public class UsuarioWeb {

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public boolean isLogado() {
		return usuario != null;
	}
	public void logout() {
		usuario = null;
	}

}
