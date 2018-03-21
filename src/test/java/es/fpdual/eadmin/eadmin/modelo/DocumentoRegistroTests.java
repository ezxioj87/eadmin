package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoRegistroTests {
	
	private static final Integer codigo_Registro = 1;
	private static final Date fecha_Creacion1= new Date();
	private static final String nombre_String = "nombre";
	private static final Boolean documento_Publico = true;
	private static String nifInteresado = "12345678A";
	private static String codigoRegistro;
	
	DocumentoRegistro documentoRegistro1 = new DocumentoRegistro(codigo_Registro,nombre_String,fecha_Creacion1,
			documento_Publico, EstadoDocumento.ACTIVO,nifInteresado,codigoRegistro);
}
