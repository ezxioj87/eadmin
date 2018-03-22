package es.fpdual.eadmin.eadmin.modelo;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

	public class ExpedienteTests {
		private static final Integer codigo_Expediente = 1;
		private static final Date fecha_Creacion= new Date();
		private static final Date fecha_Archivacion= new Date();
		private static final String nombre_String = "nombre";
		private static final Boolean documento_Publico = true;
		private static List<Documento> documentos;
		private static final Date fechaUltimaModificacion = new Date();
		Expediente expediente1 = new Expediente (codigo_Expediente,nombre_String,fecha_Creacion,fecha_Archivacion,
				documento_Publico, EstadoExpediente.ENTRAMITE,documentos,fechaUltimaModificacion);
/*		
		@Before
		@Test
		 public void deberiaProbarLosGetter() {
			
			assertEquals(Integer.valueOf(codigo_Documento), documento1.getCodigo());
			assertEquals(nombre_String, documento1.getNombre());
			assertEquals(fecha_Creacion, documento1.getFechaCreacion());
			assertEquals(documento_Publico, documento1.getPublico());
			assertEquals(EstadoDocumento.ACTIVO, documento1.getEstado());
			
		}
*/		
		@Before
		@Test
		public void probarGetDocumentos() {	
			expediente1.getDocumentos();
		}
		
		@Before
		@Test
		public void deberiaDevolverTrueSiTienenTodosLosElementosIgualesExecptoLaLista() {	
			Expediente expediente2 = new Expediente (codigo_Expediente,nombre_String,fecha_Creacion,fecha_Archivacion,
					documento_Publico, EstadoExpediente.ENTRAMITE,documentos,fechaUltimaModificacion);
			assertEquals(true,expediente1.equals(expediente2));
		}
		@Before
		@Test
		public void deberiaDevolverFalseSiNoTienenIgualTodosLosDatosExceptoLaLista() {	
			Expediente expediente2 = new Expediente (1,nombre_String,fecha_Creacion,fecha_Archivacion,
					false, EstadoExpediente.ARCHIVADO,null,null);
			Expediente expediente3 = new Expediente (1,nombre_String,fecha_Creacion,fecha_Archivacion,
					false, EstadoExpediente.INICIADO,null,null);
			assertEquals(false,expediente1.equals(expediente2));
			assertEquals(false,expediente1.equals(expediente3));
		}
		
		@Before
		@Test
		public void deberiaDevolverFalseSiNoIntroducesDosCodigos() {	
			assertEquals(false,expediente1.equals(1));
		}
		
		@Before
		@Test
		public void probarMetodoToStringClaseExpediente() {
			assertEquals("Expediente codigo=" + codigo_Expediente + ", nombre=" + nombre_String + ", fechaCreacion=" + fecha_Creacion
					+ ", fechaArchivado=" + fecha_Archivacion + ", publico=" + documento_Publico + ","
							+ " estado=" + EstadoExpediente.ENTRAMITE,expediente1.toString());
		}
		
		@Before
		@Test
		public void probarHashCodeClaseExpediente() {
			final int resultado = expediente1.hashCode();
			assertEquals(expediente1.hashCode(),resultado);
		}
	
}
