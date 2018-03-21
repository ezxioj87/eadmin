package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoContable extends Documento{
	
	private BigDecimal importe;
	private String nifInteresado;
	
	public DocumentoContable(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,
			EstadoDocumento estado, BigDecimal importe,String nifInteresado) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.importe = importe;
		this.nifInteresado = nifInteresado;
	}
	
	
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public String getNifInteresado() {
		return nifInteresado;
	}


	@Override
	public String toString() {
		return "DocumentoContable [importe=" + importe + ", nifInteresado=" + nifInteresado + "]";
	}


	
	
	
	
	
	
}
