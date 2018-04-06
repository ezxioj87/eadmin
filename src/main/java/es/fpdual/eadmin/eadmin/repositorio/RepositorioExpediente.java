package es.fpdual.eadmin.eadmin.repositorio;

import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	public abstract void altaExpediente (Expediente expediente);
	public abstract void modificarExpediente (Expediente expediente);
	public abstract void eliminarExpediente (Integer codigo);
	Expediente obtenerExpedientePorCodigo(Integer codigo);

}
