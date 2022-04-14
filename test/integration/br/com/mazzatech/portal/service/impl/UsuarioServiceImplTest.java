package br.com.mazzatech.portal.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import base.dbunit.DbUnitManager;
import br.com.mazzatech.portal.model.Usuario;
import br.com.mazzatech.portal.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./WebContent/WEB-INF/config/spring/applicationContext.xml",
								   "file:./WebContent/WEB-INF/config/spring/applicationContext-persistence-test.xml"})
@Transactional
public class UsuarioServiceImplTest {

	private static final String dbUnitDataSet = "test/integration/base/dbunit/xml/UsuarioServiceImplTest.xml";
	
	@Autowired
	DbUnitManager dbUnitManager;
	@Autowired
	UsuarioService service;
	
	@Before
	public void setup() {
		dbUnitManager.cleanAndInsert(dbUnitDataSet);
	}
	
	@Test
	public void deveriaAutenticarUsuario() {
		Usuario usuario = service.autentica("lpedrosa", "secret");
		
		assertNotNull("Usuário encontrado", usuario);
		assertEquals("login","lpedrosa", usuario.getLogin());
		assertEquals("nome","Leandro Pedrosa", usuario.getNome());
	}
	
	@Test
	public void deveriaNaoAutenticarUsuario() {
		Usuario usuario = service.autentica("invalid", "user");
		assertNull("Usuário encontrado", usuario);
	}
	
}
