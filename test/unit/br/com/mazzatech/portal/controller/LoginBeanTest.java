package br.com.mazzatech.portal.controller;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.mazzatech.portal.model.Usuario;
import br.com.mazzatech.portal.service.UsuarioService;
import br.com.mazzatech.portal.util.FacesUtils;
import junit.framework.Assert;

public class LoginBeanTest {

	LoginBean controller;
	
	private UsuarioWeb usuarioWeb;
	@Mock
	private UsuarioService usuarioService;
	@Mock
	private FacesUtils facesUtils;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		usuarioWeb = new UsuarioWeb();
		controller = new LoginBean(usuarioWeb, usuarioService, facesUtils);
	}
	
	@Test
	public void logandoNaAplicacao() {
		
		seExisteUsuarioCadastradoCom("usuario", "senha");
		
		quandoUsuarioEntraCom("usuario", "senha");
		
		String outcome = controller.logar();
		
		Assert.assertEquals("home", outcome);
		Assert.assertTrue(usuarioWeb.isLogado());
	}
	
	@Test
	public void naoLogaQuandoUsuarioInvalido() {
		
		quandoUsuarioEntraCom("invalido", "senha");
		
		String outcome = controller.logar();
		
		Assert.assertNull("Deveria continuar na mesma página", outcome);
		Assert.assertFalse(usuarioWeb.isLogado());
		verify(facesUtils, only()).adicionaMensagemDeErro("Login ou senha inválida.");
	}
	
	@Test
	public void deslogandoDaAplicacao() {
		
		seExisteUsuarioLogado();
		
		String outcome = controller.sair();
		
		Assert.assertEquals("login", outcome);
		Assert.assertFalse(usuarioWeb.isLogado());
	}

	private void seExisteUsuarioLogado() {
		usuarioWeb.loga(new Usuario("user", "secret"));
	}

	private void quandoUsuarioEntraCom(String login, String senha) {
		controller.setLogin(login);
		controller.setSenha(senha);
	}

	private void seExisteUsuarioCadastradoCom(String login, String senha) {
		Usuario usuario = new Usuario(login, senha);
		when(usuarioService.autentica(login, senha)).thenReturn(usuario);
	}
	
}
