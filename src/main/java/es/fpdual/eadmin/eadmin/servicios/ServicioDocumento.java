package es.fpdual.eadmin.eadmin.servicios;

import java.util.List;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	Documento altaDocumento(Documento documento1);

	public Documento modificarDocumento(Documento documento1);

	void eliminarDocumento(Integer codigo);
	
	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);
	
	public abstract List<Documento> obtenerTodosLosDocumentos();

	Documento obtenerDocumentoConFechaCreacionCorrecta(Documento documento);

	Documento modificarDocumentoConFechaCreacionCorrecta(Documento documento);

}
