package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class RepositorioDocumentoImplTest {
	private Date fechaCreacion =new Date();
	private Boolean publico = true;
	private RepositorioDocumentoImpl repositorioDocumento;
	Documento documento1 = new Documento(1,"nombre",fechaCreacion,publico, EstadoDocumento.ACTIVO);
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}
	
	@Test
	public void deberiaDarDeAltaUnDocumento() {
		this.repositorioDocumento.altaDocumento(documento1);
		assertFalse(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
/*	@Test
	public void deberiaSaltarExcepcionAlDarDeAltaUnDocumento() {
		this.repositorioDocumento.altaDocumento(documento1);
		this.repositorioDocumento.altaDocumento(documento1);
		assertFalse(this.repositorioDocumento.getDocumentos().isEmpty());
	}
*/	
	@Test
	public void deberiaEliminarUnDocumento() {
		this.repositorioDocumento.getDocumentos().add(documento1);
		
		this.repositorioDocumento.eliminarDocumento(documento1.getCodigo());
		
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	@Test
	public void deberiaNoEliminarUnDocumentoSiNoExiste() {
		this.repositorioDocumento.eliminarDocumento(documento1.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
	@Test
	public void debeModificarUnArchivo() {
		this.repositorioDocumento.modificarDocumento(documento1);
		
	}
	
}
