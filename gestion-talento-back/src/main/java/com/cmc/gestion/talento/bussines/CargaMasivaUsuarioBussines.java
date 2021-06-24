package com.cmc.gestion.talento.bussines;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.type.TipoArea;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;
import com.cmc.gestion.talento.web.gestiondoc.FilesStorageService;
@Service
public class CargaMasivaUsuarioBussines {
	
	@Autowired
	private EmpleadoBussines empleadoBussines;
	
	@Autowired
	private FilesStorageService filesStorageService;
	
	public void guardarArchivo(String file) {
		try {
			convertFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void convertFile(String file) throws IOException{
		Resource resource =filesStorageService.load(file);
		FileInputStream fileInStream = new FileInputStream(resource.getFile());
		XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
		XSSFSheet selSheet = workBook.getSheetAt(0);
		Iterator<Row> rowIterator = selSheet.iterator();
		int contLinea=0;
		while (rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		        if(contLinea!=0) {
		        	Iterator<Cell> cellIterator = row.cellIterator();
			        StringBuffer stringBuffer = new StringBuffer();
			        while (cellIterator.hasNext()) {
			        Cell cell = cellIterator.next();
			        if (stringBuffer.length() != 0) {
			                stringBuffer.append(";");
			        }
			        stringBuffer.append(getValue(cell));
			        }
			        try {
			        	MapEmpleadoDto(stringBuffer.toString());
			        }catch (ArqGestionExcepcion e) {
						// TODO: handle exception
					}
			        
		        }
		        contLinea++;
		}
		workBook.close();
	}
	
	private EmpleadoDto MapEmpleadoDto(String row) throws ArqGestionExcepcion{
		String[] empleadoRow=row.split(";");
		EmpleadoDto empleado= new EmpleadoDto();
		empleado.setTipoDocumento(TipoDocumento.valueOf(empleadoRow[0]));
		empleado.setDocumento(empleadoRow[1]);
		empleado.setPrimerNombre(empleadoRow[2]);
		empleado.setSegundoNombre(empleadoRow[3]);
		empleado.setPrimerApellido(empleadoRow[4]);
		empleado.setSegundoApellido(empleadoRow[5]);
		empleado.setCorreoElectronico(empleadoRow[6]);
		empleado.setTelefono(empleadoRow[7]);
		empleado.setArea(TipoArea.valueOf(empleadoRow[8]));
		empleado.setJefe(empleadoRow[9]);
		empleado.setIdUsuario(empleadoRow[10]);
		empleado.setPerfil(TipoPerfil.valueOf(empleadoRow[11]));
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmpleadoDto>> violations =validator.validate(empleado);
		for (ConstraintViolation<EmpleadoDto> violation : violations) {
			throw new ArqGestionExcepcion(violation.getMessage(),
					ExcepcionType.ERROR_VALIDATION);
		}
		return empleado;
	}
	
	private String getValue(Cell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return   String.format ("%.0f", cell.getNumericCellValue());  
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return  Boolean.toString(cell.getBooleanCellValue());
		default:
			return null;
		}
	}
}
