package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloBaseAdministracionElectronica{
	protected Date fechaArchivado = new Date();
	protected EstadoExpediente estado;
	protected List<Documento> documentos;
	
	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado, List<Documento> documentos,Date fechaUltimaModificacion) {
		super(codigo,nombre,fechaCreacion,publico,fechaUltimaModificacion);
		this.fechaArchivado = fechaArchivado;
		this.estado = estado;
		this.documentos = documentos;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}


	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public String toString() {
		return "Expediente codigo=" + codigo + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion
				+ ", fechaArchivado=" + fechaArchivado + ", publico=" + publico + ", estado=" + estado ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Expediente) {
		return codigo.equals(((Expediente)obj).getCodigo()) 
				&& nombre.equals(((Expediente)obj).getNombre())
				&& fechaCreacion.equals(((Expediente)obj).getFechaCreacion()) 
				&& fechaArchivado.equals(((Expediente)obj).getFechaArchivado())
				&& publico.equals(((Expediente)obj).getPublico()) 
				&& estado.equals(((Expediente)obj).getEstado());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode()+nombre.hashCode()+fechaCreacion.hashCode()+fechaArchivado.hashCode()
		+publico.hashCode()+estado.hashCode();
	}
	
	
	
	
	
	
	
	
	

	
	
	
}
