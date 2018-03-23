package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class RepositorioExpedienteImpl implements RepositorioExpediente{
	
private List<Expediente> expedientes = new ArrayList<>();
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void altaExpediente(Expediente expediente) {
		if(expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente está en la lista");
		}
		
		expedientes.add(expediente);		
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente a modificar no existe");	
			}
			
			expedientes.set(expedientes.indexOf(expediente), expediente);
		}
		

	@Override
	public void eliminarExpediente(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = 
				expedientes.stream().filter(d -> tieneIgualCodigo(d,codigo)).
				findFirst();
	if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());
		}
	}
	
	protected static boolean tieneIgualCodigo(Expediente expediente, Integer codigo) {
		return expediente.getCodigo().equals(codigo);
	}
		
	}
	
	
