package es.fpdual.eadmin.eadmin.controlador;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.servicios.ServicioDocumento;

@RestController
public class ControladorEadmin {
	
	private final ServicioDocumento servicioDocumento;
	
	@Autowired
	public ControladorEadmin(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}
	
	@GetMapping(value="/eadmin/documentos")
	public ResponseEntity<List<Documento>> getTodosDocumentos(){
		return new ResponseEntity<List<Documento>>(
				servicioDocumento.obtenerTodosLosDocumentos(), HttpStatus.OK);
	}
	
	@GetMapping(value="/eadmin/documentos/{codigo}")
	public ResponseEntity<Documento> getDocumentoPorCodigo(@PathVariable("codigo") Integer codigo){
		final Documento documento = this.servicioDocumento.obtenerDocumentoPorCodigo(codigo);
		if(Objects.nonNull(documento)) {
		return new ResponseEntity<Documento>(
				servicioDocumento.obtenerDocumentoPorCodigo(codigo), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/eadmin/documentos/eliminar/{codigo}")
	public ResponseEntity<?> eliminarDocumeto(@PathVariable("codigo") Integer codigo){
		this.servicioDocumento.eliminarDocumento(codigo);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
