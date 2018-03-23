package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {
	
	RepositorioDocumento  repositorioDocumento;
	
	
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}
	
	@Override
	public Documento altaDocumento(Documento documento) {
		
		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
		
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		repositorioDocumento.modificarDocumento(documento);
		
	}


	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}
	
	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento1) {
		
		return new DocumentoBuilder().clonar(documento1).conFechaCreacion(dameFechaActual()).construir();
	}

	protected static Date dameFechaActual() {
		return new Date();
	}
}
