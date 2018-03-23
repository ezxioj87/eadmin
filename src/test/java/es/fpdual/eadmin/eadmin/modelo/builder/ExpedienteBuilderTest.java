package es.fpdual.eadmin.eadmin.modelo.builder;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ExpedienteBuilderTest {
	private Expediente expediente;
	private static final Date fechaCreacion = new Date();
	private static final Date fechaArchivacion = new Date();
	private static final Date fechaUltimaModificacion = new Date();
	private List<Documento> documentos;

	@Before
	public void deberiaCrearUnDocumento() {
		expediente = new ExpedienteBuilder().conCodigo(1).conNombre("nombre").conFechaCreacion(fechaCreacion)
				.conPublico(true).conEstado(EstadoExpediente.ARCHIVADO).conFechaUltimaModificacion(fechaUltimaModificacion)
				.conListaDocumentos(documentos).conFechaArchivado(fechaArchivacion).construir();
	}

	@Test
	public void deberiaClonarUnDocumento() {
		Expediente expediente2 = new ExpedienteBuilder().clonar(expediente).construir();
		assertEquals(expediente, expediente2);
		assertEquals(expediente.getDocumentos(), expediente2.getDocumentos());
		assertEquals(expediente.getFechaArchivado(), expediente2.getFechaArchivado());

	}

}
