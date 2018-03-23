package es.fpdual.eadmin.eadmin.modelo.builder;

import java.math.BigDecimal;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.DocumentoContable;

public class DocumentoContableBuilder extends DocumentoBuilder {
	
	protected BigDecimal importe;
	protected String nifInteresado;
	
	@Override
	public DocumentoContable construir() {
		return new DocumentoContable(this.codigo,this.nombre,this.fechaCreacion,this.publico,this.estado,importe,nifInteresado,this.fechaUltimaModificacion); 
	}
	
	public DocumentoContableBuilder conImporte(BigDecimal importe) {
		this.importe = importe;
		return this;
	}
	
	public DocumentoContableBuilder conNifIntersado(String nifInteresado) {
		this.nifInteresado = nifInteresado;
		return this;
	}
	
	public DocumentoContableBuilder clonar(DocumentoContable documentoContable) {
		super.clonar(documentoContable);
		this.importe = documentoContable.getImporte();
		this.nifInteresado = documentoContable.getNifInteresado();
		return this;
	}

}
