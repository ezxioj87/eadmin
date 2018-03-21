package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DocumentoContableTests {
	
	private static final Integer codigo_Contable = 1;
	private static final Date fechaCreacion= new Date();
	private static final String nombre_String = "nombre";
	private static final Boolean documento_Publico = true;
	private static BigDecimal importe = new BigDecimal(0.0);
	private static String nifInteresado = "12345678A";
	DocumentoContable documentoContable1 = new DocumentoContable(codigo_Contable,nombre_String,fechaCreacion,
			documento_Publico, EstadoDocumento.ACTIVO,importe,nifInteresado);
	
	@Before
	@Test
	public void probarLosMetodosGetterClaseDocumetoContable() {
		documentoContable1.getImporte();
		documentoContable1.getNifInteresado();
	}
	
	@Before
	@Test
	public void probarMetodoToStringClaseDocumentoContable() {
		assertEquals("DocumentoContable [importe=" + documentoContable1.getImporte() +
				", nifInteresado=" + documentoContable1.getNifInteresado() + "]",documentoContable1.toString());
	}
	
}
