package es.fpdual.eadmin.eadmin.servicios.impl;

import java.util.Date;
import java.util.List;

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
		
		final Documento documentoModificado = obtenerDocumentoConFechaCreacionCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		
		return documentoModificado;
		
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		
		repositorioDocumento.modificarDocumento(documento);
		
		return documento;
		
	}


	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
		
	}
	


	protected static Date dameFechaActual() {
		return new Date();
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return this.repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		// TODO Auto-generated method stub
		return repositorioDocumento.obtenerTodosLosDocumentos();
	}
	
	@Override
	public Documento obtenerDocumentoConFechaCreacionCorrecta(Documento documento) {
		return new DocumentoBuilder().clonar(documento).conFechaCreacion(dameFechaActual()).construir();
		
	}
	
	@Override
	public Documento modificarDocumentoConFechaCreacionCorrecta(Documento documento) {
		final Documento documentoModificado = obtenerDocumentoConFechaCreacionCorrecta(documento);
		repositorioDocumento.modificarDocumento(documentoModificado);
		return documentoModificado;
		
		
	}
}
