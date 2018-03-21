package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTests {
	private static final Integer codigo_Documento = 1;
	private static final Date fecha_Creacion= new Date();
	private static final String nombre_String = "nombre";
	private static final Boolean documento_Publico = true;
	Documento documento1 = new Documento(codigo_Documento,nombre_String,fecha_Creacion,documento_Publico, EstadoDocumento.ACTIVO);
	@Before
	@Test
	 public void deberiaProbarLosGetter() {
		
		assertEquals(Integer.valueOf(codigo_Documento), documento1.getCodigo());
		assertEquals(nombre_String, documento1.getNombre());
		assertEquals(fecha_Creacion, documento1.getFechaCreacion());
		assertEquals(documento_Publico, documento1.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, documento1.getEstado());
		
	}
	@Before
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {	
		Documento documento2 = new Documento(codigo_Documento,null,null,null,null);
		assertEquals(true,documento1.equals(documento2));
	}
	@Before
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {	
		Documento documento2 = new Documento(2,nombre_String,fecha_Creacion,documento_Publico, EstadoDocumento.ELIMINADO);
		assertEquals(false,documento1.equals(documento2));
		Documento documento3 = new Documento(2,nombre_String,fecha_Creacion,documento_Publico, EstadoDocumento.APROBDO);
		assertEquals(false,documento1.equals(documento3));
	}
	
	@Before
	@Test
	public void deberiaDevolverFalseSiNoIntroducesDosCodigos() {	
		assertEquals(false,documento1.equals(1));
	}
	
	@Before
	@Test
	public void probarMetodoToStringClaseDocument() {
		assertEquals("Documento con código"+1,documento1.toString());
	}
	
	@Before
	@Test
	public void probarHashCodeClaseDocument() {
		final int resultado = documento1.hashCode();
		assertEquals(codigo_Documento.hashCode(),resultado);
	}
}
