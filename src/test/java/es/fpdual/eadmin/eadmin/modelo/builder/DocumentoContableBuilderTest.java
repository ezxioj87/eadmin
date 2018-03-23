package es.fpdual.eadmin.eadmin.modelo.builder;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilderTest {
	
private DocumentoContable documento1 =  new DocumentoContableBuilder().construir();
	
	
	@Before
	@Test
	public void deberiaCrearUnDocumentoContable() {
		DocumentoContable documento2 = new DocumentoContableBuilder().clonar(documento1).conImporte(null).conNifIntersado(null).construir();
		assertEquals(documento1.getImporte(),documento2.getImporte());
		assertEquals(documento1.getNifInteresado(),documento2.getNifInteresado());
	}
	

}
