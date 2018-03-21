package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoRegistro extends Documento{
	
	private String nifInteresado;
	private String codigoRegistro;
	
	public DocumentoRegistro(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			EstadoDocumento estado,String nifInteresado,String codigoRegistro) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		// TODO Auto-generated constructor stub
		this.nifInteresado = nifInteresado;
		this.codigoRegistro = codigoRegistro;
	}

	public String getNifInteresado() {
		return nifInteresado;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	@Override
	public String toString() {
		return "DocumentoRegistro [nifInteresado=" + nifInteresado + ", codigoRegistro=" + codigoRegistro + "]";
	}
	
	
	

}
