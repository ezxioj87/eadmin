package es.fpdual.eadmin.eadmin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
//import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

@Component
public class CargarDatosIniciales implements ApplicationRunner {
	
	
	public final RepositorioDocumento repositorioDocumeto;
//	public final RepositorioExpediente repositorioExpediente;
	private static final Date Fecha = new Date();
	public List<Documento> documentos = new ArrayList();
	Expediente expediente1 = new Expediente(1, "Documento1", Fecha, Fecha , true, EstadoExpediente.ARCHIVADO, documentos ,Fecha);
	Expediente expediente2 = new Expediente(2, "Documento1", Fecha, Fecha , true, EstadoExpediente.ARCHIVADO, documentos,Fecha);
	
	@Autowired
	public CargarDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumeto = repositorioDocumento;
//		this.repositorioExpediente = repositorioExpediente;
	}
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Documento documento = new Documento(1, "Documento1", Fecha, true, EstadoDocumento.ACTIVO, Fecha); 
				
		this.repositorioDocumeto.altaDocumento(documento);
		
		this.repositorioDocumeto.altaDocumento(new Documento(2, "Documento2", Fecha, false, EstadoDocumento.APROBDO, Fecha));
		
		this.repositorioDocumeto.altaDocumento(new Documento(3, "Documento3", Fecha, true, EstadoDocumento.ELIMINADO, Fecha));
		
		RepositorioDocumentoImpl.archivarTodosLosDocumentos(this.repositorioDocumeto.obtenerTodosLosDocumentos());
		
		this.repositorioDocumeto.modificarDocumento(documento);
		
		
//		this.repositorioExpediente.altaExpediente(expediente1);
//		
//		this.repositorioExpediente.modificarExpediente(expediente1);
//		
//		
//		this.repositorioExpediente.eliminarExpediente(2);
	}
	

}
