package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private List<Expediente> expedientes = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		logger.info("Entrando en altaExpediente");
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente está en la lista");
		}

		expedientes.add(expediente);
		archivarAltaExpediente(expediente);
		logger.info("Saliendo de altaDocumento");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		logger.info("Entrando en modificarExpdiente");
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente a modificar no existe");
		}

		expedientes.set(expedientes.indexOf(expediente), expediente);
		archivarModificarExpediente(expediente);
		logger.info("Saliendo de modificarExpediente");
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		logger.info("Entrando en eliminarExpediente");
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();
		if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());
			archivarEliminarExpediente(codigo);
		}
		logger.info("Saliendo de eliminarExpediente");
	}

	protected static boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}
	
	protected static void archivarAltaExpediente(Expediente exp) {
		String nombreFichero = "AltaExpediente.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero,true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: "+exp.getCodigo());
		writer.println("Nombre: "+exp.getNombre());
		writer.println("Fecha Creacion "+exp.getFechaCreacion());
		writer.println("Publico: "+exp.getPublico());
		writer.println("Estado: "+exp.getEstado());
		writer.println("Documentos: "+exp.getDocumentos());
		writer.println("Fecha UltimaModificación: "+exp.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();
		
	}
	
	protected static void archivarModificarExpediente(Expediente exp) {
		String nombreFichero = "ModificarExpediente.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero,true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: "+exp.getCodigo());
		writer.println("Nombre: "+exp.getNombre());
		writer.println("Fecha Creacion "+exp.getFechaCreacion());
		writer.println("Publico: "+exp.getPublico());
		writer.println("Estado: "+exp.getEstado());
		writer.println("Documentos: "+exp.getDocumentos());
		writer.println("Fecha UltimaModificación: "+exp.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();
		
	}
	
	protected void archivarEliminarExpediente(Integer codigo) {
		
		Expediente exp= this.obtenerExpedientePorCodigo(codigo);
		String nombreFichero = "EliminarExpediente.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero,true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: "+exp.getCodigo());
		writer.println("Nombre: "+exp.getNombre());
		writer.println("Fecha Creacion "+exp.getFechaCreacion());
		writer.println("Publico: "+exp.getPublico());
		writer.println("Estado: "+exp.getEstado());
		writer.println("Documentos: "+exp.getDocumentos());
		writer.println("Fecha UltimaModificación: "+exp.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();
		
	}
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		logger.info("Entrando en obtenerDocumentoPorCodigo");
		Optional<Expediente> expedienteEncontrado = 
				expedientes.stream().filter(d -> tieneIgualCodigo(d,codigo)).
				findFirst();
		if(expedienteEncontrado.isPresent()) {
			logger.info("Saliendo de obtenerDocumentoPorCodigo");
			return expedienteEncontrado.get();
		}
		logger.info("Saliendo de obtenerDocumentoPorCodigo");
		return null;
		
	}

}
