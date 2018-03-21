package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ModeloBaseAdministracionElectronicaTests {
	
	class ModeloBaseAdministracionElectronicaFake extends ModeloBaseAdministracionElectronica{

		public ModeloBaseAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Boolean publico) {
			super(codigo, nombre, fechaCreacion, publico);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	private static final Integer codigoDocumento = 1;
	private static final Date fechaCreacion= new Date();
	private static final String nombreString = "nombre";
	private static final Boolean documentoPublico = true;
	
	ModeloBaseAdministracionElectronicaFake modeloBase = new ModeloBaseAdministracionElectronicaFake(codigoDocumento, 
			nombreString,fechaCreacion,documentoPublico);
	
	@Before
	@Test
	 public void deberiaProbarLosGetter() {
		
		assertEquals(Integer.valueOf(codigoDocumento), modeloBase.getCodigo());
		assertEquals(nombreString, modeloBase.getNombre());
		assertEquals(fechaCreacion, modeloBase.getFechaCreacion());
		assertEquals(documentoPublico, modeloBase.getPublico());
		
	}
	@Before
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {	
		ModeloBaseAdministracionElectronicaFake modeloBase2 = new ModeloBaseAdministracionElectronicaFake(codigoDocumento, 
				null,null,null);
		assertEquals(true,modeloBase.equals(modeloBase2));
	}
	@Before
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {	
		ModeloBaseAdministracionElectronicaFake modeloBase2 = new ModeloBaseAdministracionElectronicaFake(2, 
				null,null,null);
		assertEquals(false,modeloBase.equals(modeloBase2));

	}
	
	@Before
	@Test
	public void deberiaDevolverFalseSiNoIntroducesDosCodigos() {	
		assertEquals(false,modeloBase.equals(1));
	}
	
	@Before
	@Test
	public void probarMetodoToStringClasePadre() {
		assertEquals("Documento con código"+modeloBase.getCodigo(),modeloBase.toString());
	}
	
	@Before
	@Test
	public void probarHashCodeClasePadre() {
		final int resultado = modeloBase.hashCode();
		assertEquals(codigoDocumento.hashCode(),resultado);
	}
	
}
