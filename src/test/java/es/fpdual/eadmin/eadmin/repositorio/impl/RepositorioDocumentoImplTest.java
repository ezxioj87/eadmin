package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class RepositorioDocumentoImplTest {
	private Date fechaCreacion =new Date();
	private Boolean publico = true;
	private RepositorioDocumentoImpl repositorioDocumento = mock(RepositorioDocumentoImpl.class);
	private static final Date fechaUltimaModificacion = new Date();
	Documento documento1 = new Documento(1,"nombre",fechaCreacion,publico, EstadoDocumento.ACTIVO,fechaUltimaModificacion);
	private List<Documento> documentos = new ArrayList<>();
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
	
/*	@Test
	public void debeModificarUnArchivo() {
		final Documento documento2 = mock(Documento.class);
		this.repositorioDocumento.altaDocumento(documento2);
		this.repositorioDocumento.modificarDocumento(documento2);
		verify(repositorioDocumento).modificarDocumento(documento2);
		
	}*/
	
	
	@Test
	public void deberiaEncontrarElDocumentoConElCodigo() {	
		this.repositorioDocumento.getDocumentos().add(documento1);
		final Documento resultado = this.repositorioDocumento.obtenerDocumentoPorCodigo(documento1.getCodigo());
		assertEquals(resultado,documento1);
	}
	
	@Test
	public void deberiaEncontrarTodosLosDocumentos() {
		List<Documento> lista = this.repositorioDocumento.obtenerTodosLosDocumentos();
		assertEquals(documentos,lista);
	}
}
