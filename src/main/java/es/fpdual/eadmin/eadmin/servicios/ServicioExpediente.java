package es.fpdual.eadmin.eadmin.servicios;

import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface ServicioExpediente {
	
	public abstract void altaExpediente (Expediente expediente);
	public abstract void modificarExpediente (Expediente expediente);
	public abstract void eliminarExpediente (Integer codigo);

}
