package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;


public class RepositorioExpedienteImplTest {
	
	private RepositorioExpedienteImpl repositorioExpediente;
	private static final Integer codigo_Expediente = 1;
	private static final Date fecha_Creacion= new Date();
	private static final Date fecha_Archivacion= new Date();
	private static final String nombre_String = "nombre";
	private static final Boolean documento_Publico = true;
	private static List<Documento> documentos;
	private static final Date fechaUltimaModificacion = new Date();
	Expediente expediente1 = new Expediente (codigo_Expediente,nombre_String,fecha_Creacion,fecha_Archivacion,
			documento_Publico, EstadoExpediente.ENTRAMITE,documentos,fechaUltimaModificacion);
	
	@Before
	public void inicializarEnCadaTest() {
		this.repositorioExpediente = new RepositorioExpedienteImpl();
	}
	
	@Test
	public void deberiaDarDeAltaUnExpediente() {
		this.repositorioExpediente.altaExpediente(expediente1);
		assertFalse(this.repositorioExpediente.getExpedientes().isEmpty());
	}

}
