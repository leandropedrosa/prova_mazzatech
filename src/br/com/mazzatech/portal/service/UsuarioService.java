package br.com.mazzatech.portal.service;

import br.com.mazzatech.portal.model.Usuario;

public interface UsuarioService {

	public Usuario autentica(String login, String senha);

}
