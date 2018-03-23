package es.fpdual.eadmin.eadmin.modelo.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public class DocumentoBuilderTest {
	private Documento documento1;
	
	
	@Before
	public void deberiaCrearUnDocumento() {
		documento1 =new DocumentoBuilder().conCodigo(1).conNombre("nombre").conFechaCreacion(null).conPublico(null).conEstado(null).conFechaUltimaModificacion(null).construir();
	}
	
	@Test
	public void deberiaClonarUnDocumento() {
		Documento documento2 =new DocumentoBuilder().clonar(documento1).construir();
		assertEquals(documento1.getCodigo(),documento2.getCodigo());
		assertEquals(documento1.getNombre(),documento2.getNombre());
		assertEquals(documento1.getFechaCreacion(),documento2.getFechaCreacion());
		assertEquals(documento1.getPublico(),documento2.getPublico());
		assertEquals(documento1.getEstado(),documento2.getEstado());
		assertEquals(documento1.getFechaUltimaModificacion(),documento2.getFechaUltimaModificacion());
		
	}
	
}
