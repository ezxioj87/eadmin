package es.fpdual.eadmin.eadmin.servicios;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface ServicioDocumento {

	Documento altaDocumento(Documento documento1);

	void modificarDocumento(Documento documento1);

	void eliminarDocumento(Integer codigo);

}
