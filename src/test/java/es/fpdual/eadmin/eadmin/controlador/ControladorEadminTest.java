package es.fpdual.eadmin.eadmin.controlador;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing; 


public class ControladorEadminTest {
	
	
	ServicioDocumento servicioDocumento = mock(ServicioDocumento.class);
	ControladorEadmin controlador;
	
	@Before
	public void inicializarAntesDeCadaTest() {
		
		this.controlador= new ControladorEadmin(servicioDocumento);
	
	}
	
	@Test
	public void deberiaDevolverTodosLosDocumentos() {
		
		final List<Documento> documentos = new ArrayList<>();
		
		when(this.servicioDocumento.obtenerTodosLosDocumentos()).thenReturn(documentos);
		
		List<Documento> resultado = this.controlador.getTodosDocumentos().getBody();
		
		assertEquals(resultado,documentos);
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		
		final List<Documento> documentos = new ArrayList<>();
		
		Documento documento = mock(Documento.class);
		
		when(documento.getCodigo()).thenReturn(1);
		
		documentos.add(documento);
		
		this.servicioDocumento.eliminarDocumento(documento.getCodigo());
		
		assertTrue(documentos.isEmpty());
	}

	
}
