package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public abstract class ModeloBaseAdministracionElectronica {
	
	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Date fechaUltimaModificacion;
	protected Boolean publico;
	
	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,Date fechaUltimaModificacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Boolean getPublico() {
		return publico;
	}
	
	@Override
	public String toString() {
		return "Documento con código" + codigo;
	}
	
	
	
	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ModeloBaseAdministracionElectronica) {
		return codigo.equals(((ModeloBaseAdministracionElectronica)obj).getCodigo());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode();
	}

}
