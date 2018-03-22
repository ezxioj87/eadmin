package es.fpdual.eadmin.eadmin.servicios.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

public class ServicioDocumenoImplTest {
	
	Documento documento1 = mock(Documento.class);
	private ServicioDocumento servicioDocumento ;
	private RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	private static final Integer codigoDoc = 1;
	
	@Before
	public void inicializarEnCadaTest() {
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
		
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(1);
		when(documento1.getFechaCreacion()).thenReturn(new Date(10/10/2017));
		when(documento1.getNombre()).thenReturn("nombre");
		final Documento resultado = this.servicioDocumento.altaDocumento(documento1);
		verify(this.repositorioDocumento).altaDocumento(any());
		assertEquals(Integer.valueOf(1),documento1.getCodigo());
		assertEquals("nombre",documento1.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), documento1.getFechaCreacion());
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		this.servicioDocumento.modificarDocumento(documento1);
		verify(this.repositorioDocumento).modificarDocumento(documento1);
		
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(documento1.getCodigo()).thenReturn(codigoDoc);
		this.servicioDocumento.eliminarDocumento(documento1.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(codigoDoc);
	}
	
	
}
