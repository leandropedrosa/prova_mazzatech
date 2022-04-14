package br.com.mazzatech.portal.controller;

import org.junit.Before;
import org.junit.Test;

import br.com.mazzatech.portal.model.Usuario;
import junit.framework.Assert;


public class UsuarioWebTest {

	UsuarioWeb usuarioWeb;
	
	@Before
	public void setup() {
		usuarioWeb = new UsuarioWeb();
	}
	
	@Test
	public void deveriaEfetuarLogin() {
		Usuario user = new Usuario("user", "secret");
		
		usuarioWeb.loga(user);
		
		Assert.assertNotNull(usuarioWeb.getUsuario());
		Assert.assertTrue(usuarioWeb.isLogado());
	}
	
	@Test
	public void deveriaEfetuarLogout() {
		seExisteUsuarioLogado();
		
		usuarioWeb.logout();
		
		Assert.assertNull(usuarioWeb.getUsuario());
		Assert.assertFalse(usuarioWeb.isLogado());
	}

	private void seExisteUsuarioLogado() {
		Usuario user = new Usuario("user", "secret");
		usuarioWeb.loga(user);		
	}
	
}
