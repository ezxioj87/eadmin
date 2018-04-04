package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import net.bytebuddy.asm.Advice.OffsetMapping.Context.ForMethodEntry;
@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento{
	
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private List<Documento> documentos = new ArrayList<>();
	RepositorioDocumento repositorioDocumento;
	public List<Documento> getDocumentos() {
		return documentos;
	}
	
	
	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando en altaDocumento");
		if(documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento está en la lista");
		}
		
		documentos.add(documento);
		logger.info(documento.toString()+" creado correctamente.");
		logger.info("Saliendo de altaDocumento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entrando en modificarDocumento");
		if (!documentos.contains(documento)) {
		throw new IllegalArgumentException("El documento a modificar no existe");	
		}
		
		documentos.set(documentos.indexOf(documento), documento);
		logger.info("Saliendo de modificarDocumento");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando en eliminarDocumento");
		Optional<Documento> documentoEncontrado = 
				documentos.stream().filter(d -> tieneIgualCodigo(d,codigo)).
				findFirst();
	if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
		}
	logger.info("Saliedo de eliminarDocumento");
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entrando en obtenerDocumentoPorCodigo");
		Optional<Documento> documentoEncontrado = 
				documentos.stream().filter(d -> tieneIgualCodigo(d,codigo)).
				findFirst();
		if(documentoEncontrado.isPresent()) {
			logger.info("Saliendo de obtenerDocumentoPorCodigo");
			return documentoEncontrado.get();
		}
		logger.info("Saliendo de obtenerDocumentoPorCodigo");
		return null;
		
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrando en obtenerTodosLosDocumento");
		for (Documento documento : documentos) {
			logger.info("************");
			logger.info("Documento: "+documento.getCodigo());
			logger.info("************");
			logger.info("Nombre: "+documento.getNombre());
			logger.info("************");
			logger.info("Fecha Creacion "+documento.getFechaCreacion());
			logger.info("************");
			logger.info("Publico: "+documento.getPublico());
			logger.info("************");
			logger.info("Estado: "+documento.getEstado());
			logger.info("************");
			logger.info("Fecha UltimaModificación: "+documento.getFechaUltimaModificacion());
		}
		logger.info("Saliendo de obtenerTodosLosDocumentos");
		return documentos;
	}
	
	protected static boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}
	

}
