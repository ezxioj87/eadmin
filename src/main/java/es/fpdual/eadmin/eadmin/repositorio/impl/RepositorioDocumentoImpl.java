package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import net.bytebuddy.asm.Advice.OffsetMapping.Context.ForMethodEntry;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {
	Integer num = 0;
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private List<Documento> documentos = new ArrayList<>();
	public RepositorioDocumento repositorioDocumento;

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando en altaDocumento");

		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento está en la lista");
		}

		documentos.add(documento);
		archivarAlta(documento);
		exportar("Alta",documento, "altaDocumento.xls");
		logger.info(documento.toString() + " creado correctamente.");
		num++;
		logger.info("Saliendo de altaDocumento");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entrando en modificarDocumento");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}

		documentos.set(documentos.indexOf(documento), documento);
		archivarModificar(documento);
		logger.info("Saliendo de modificarDocumento");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		logger.info("Entrando en eliminarDocumento");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();
		if (documentoEncontrado.isPresent()) {
			archivarEliminar(codigo);
			documentos.remove(documentoEncontrado.get());
		}
		logger.info("Saliedo de eliminarDocumento");
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entrando en obtenerDocumentoPorCodigo");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();
		if (documentoEncontrado.isPresent()) {
			logger.info("Saliendo de obtenerDocumentoPorCodigo");
			return documentoEncontrado.get();
		}
		logger.info("Saliendo de obtenerDocumentoPorCodigo");
		return null;

	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrando en obtenerTodosLosDocumento");
		for (Documento documento : documentos) {
			logger.info("************");
			logger.info("Documento: " + documento.getCodigo());
			logger.info("************");
			logger.info("Nombre: " + documento.getNombre());
			logger.info("************");
			logger.info("Fecha Creacion " + documento.getFechaCreacion());
			logger.info("************");
			logger.info("Publico: " + documento.getPublico());
			logger.info("************");
			logger.info("Estado: " + documento.getEstado());
			logger.info("************");
			logger.info("Fecha UltimaModificación: " + documento.getFechaUltimaModificacion());
		}
		logger.info("Saliendo de obtenerTodosLosDocumentos");
		return documentos;
	}

	protected static boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public static void archivarTodosLosDocumentos(List<Documento> documentos) {
		String nombreFichero = "documentos.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Documento doc : documentos) {
			writer.println("************");
			writer.println("Codigo: " + doc.getCodigo());
			writer.println("Nombre: " + doc.getNombre());
			writer.println("Fecha Creacion " + doc.getFechaCreacion());
			writer.println("Publico: " + doc.getPublico());
			writer.println("Estado: " + doc.getEstado());
			writer.println("Fecha UltimaModificación: " + doc.getFechaUltimaModificacion());
			writer.println("************");

		}
		writer.close();
	}

	protected static void archivarAlta(Documento doc) {
		String nombreFichero = "Alta.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: " + doc.getCodigo());
		writer.println("Nombre: " + doc.getNombre());
		writer.println("Fecha Creacion " + doc.getFechaCreacion());
		writer.println("Publico: " + doc.getPublico());
		writer.println("Estado: " + doc.getEstado());
		writer.println("Fecha UltimaModificación: " + doc.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();

	}

	protected static void archivarModificar(Documento doc) {
		String nombreFichero = "Modificar.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: " + doc.getCodigo());
		writer.println("Nombre: " + doc.getNombre());
		writer.println("Fecha Creacion " + doc.getFechaCreacion());
		writer.println("Publico: " + doc.getPublico());
		writer.println("Estado: " + doc.getEstado());
		writer.println("Fecha UltimaModificación: " + doc.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();

	}

	protected void archivarEliminar(Integer codigo) {

		Documento documentoEncontrado = this.obtenerDocumentoPorCodigo(codigo);
		String nombreFichero = "Eliminar.txt";
		FileWriter fw;
		PrintWriter writer = null;
		try {
			fw = new FileWriter(nombreFichero, true);
			writer = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("************");
		writer.println("Codigo: " + documentoEncontrado.getCodigo());
		writer.println("Nombre: " + documentoEncontrado.getNombre());
		writer.println("Fecha Creacion " + documentoEncontrado.getFechaCreacion());
		writer.println("Publico: " + documentoEncontrado.getPublico());
		writer.println("Estado: " + documentoEncontrado.getEstado());
		writer.println("Fecha UltimaModificación: " + documentoEncontrado.getFechaUltimaModificacion());
		writer.println("************");
		writer.close();

	}

	protected void exportar(String nomHoja,Documento documento, String ruta) {
		num =0;
		Map<String,Object[]> data = new TreeMap<String, Object[]>();
		File archivo = new File(ruta);
		if(!archivo.exists()) {
			data.put("0", new Object[] {"ID", "Nombre", "Fecha Creacion", "Publico", "Estado", "Fecha Ultima Modificación"});
			num++;
		}else {
			ArrayList<String[]> datosExcel = importExcel(ruta,4);
			ListIterator<String[]> it = datosExcel.listIterator();
			
			while ( it.hasNext()) {
				num++;
				String[] datos = it.next();
				data.put(num.toString(),datos);
			}
		}
		num++;
		data.put(num.toString(), new Object[] {documento.getCodigo().toString(),documento.getNombre(),
				documento.getFechaCreacion().toString(),documento.getPublico().toString(),
				documento.getEstado().toString(),documento.getFechaUltimaModificacion().toString()});
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(nomHoja);
		
		int ultimaFila = sheet.getLastRowNum();
		Set<String> keyset = data.keySet();
		int rowNum = ultimaFila+1;
		for (String key : keyset) {
			Row row = sheet.createRow(rowNum);
		}
		HSSFRow nombreFila = sheet.createRow(0);
		HSSFRow nombreFila1 = sheet.createRow(1);
	
		try {
            // Creamos el flujo de salida de datos,
            // apuntando al archivo donde queremos 
            // almacenar el libro de Excel
            FileOutputStream salida = new FileOutputStream(archivo,true);
            
            // Almacenamos el libro de 
            // Excel via ese 
            // flujo de datos
            workbook.write(salida);
            
            // Cerramos el libro para concluir operaciones
            workbook.close();
            
            
            
        } catch (FileNotFoundException ex) {
           System.out.println("Error");
        } catch (IOException ex) {
            System.out.println("Error");
        }
         
	}

	@SuppressWarnings("deprecation")
	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
			ArrayList<String[]> data = new ArrayList<>();

			try {
				// Acceso al fichero xlsx
		FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Obtenemos la primera hoja
				XSSFSheet sheet = workbook.getSheetAt(0);

				// Iterador de filas
				Iterator<Row> rowIterator = sheet.iterator();

				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					// Iterador de celdas
			Iterator<Cell> cellIterator = row.cellIterator();
	// contador para el array donde guardamos los datos de cada fila
					int contador = 0;
				// Array para guardar los datos de cada fila 
					// y añadirlo al ArrayList
					String[] fila = new String[numColums];
					// iteramos las celdas de la fila
			while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

			// Guardamos los datos de la celda segun su tipo
						switch (cell.getCellType()) {
						//si es numerico
					case Cell.CELL_TYPE_NUMERIC:
			fila[contador] = (int) cell.getNumericCellValue() + "";
							break;
						// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
			fila[contador] = cell.getStringCellValue() + "";
							break;
						}
			// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
			// Añadimos la fila al ArrayList con todos los datos
							data.add(fila);
						}
		// Incrementamos el contador
		// con cada fila terminada al redeclarar arriba el contador,
			// no obtenemos excepciones de ArrayIndexOfBounds
						contador++;
					}
				}
				// Cerramos el fichero y workbook
				file.close();
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Excel importado correctamente\n");

			return data;
		}
}
