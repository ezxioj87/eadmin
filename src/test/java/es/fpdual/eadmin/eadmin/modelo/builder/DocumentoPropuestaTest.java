package es.fpdual.eadmin.eadmin.modelo.builder;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.DocumentoPropuesta;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class DocumentoPropuestaTest {
	DocumentoPropuesta documento;
	
	@Before
	public void inicializarAntes() {
		documento = new DocumentoPropuesta(1, "nombre", null, null,null,1, 1, "grupo",null);
	}
	
	@Test
	public void deberiaDarElCodigoDePropuestaDelDocumento() {
		
	}
}
