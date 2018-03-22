package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTests {
	private static final Integer codigo_Documento = 1;
	private static final Date fecha_Creacion= new Date();
	private static final String nombre_String = "nombre";
	private static final Boolean documento_Publico = true;
	private static final Date fechaUltimaModificacion = new Date();
	Documento documento1 = new Documento(codigo_Documento,nombre_String,fecha_Creacion,documento_Publico, EstadoDocumento.ACTIVO,fechaUltimaModificacion);
	
	@Before
	@Test
	public void probarGetterEstadoClaseDocumento() {
		documento1.getEstado();
	}
	
}
