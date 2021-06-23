package com.cmc.gestion.talento.bussines;

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

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;

public class CargaMasivaUsuarioBussines {
	
	
	
	private void convertFile(String xlsx, String csv) throws IOException{
		// Open and existing XLSX file
		FileInputStream fileInStream = new FileInputStream("LargeDocument.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
		XSSFSheet selSheet = workBook.getSheetAt(0);
		// Loop through all the rows
		Iterator<Row> rowIterator = selSheet.iterator();
		while (rowIterator.hasNext()) {
		        Row row = rowIterator.next();
		        // Loop through all rows and add ","
		        Iterator<Cell> cellIterator = row.cellIterator();
		        StringBuffer stringBuffer = new StringBuffer();
		        while (cellIterator.hasNext()) {
		        Cell cell = cellIterator.next();
		        if (stringBuffer.length() != 0) {
		                stringBuffer.append(";");
		        }
		        stringBuffer.append(cell.getStringCellValue());
		        }
		        System.out.println(stringBuffer.toString());
		}
		workBook.close();
	}
	
	public EmpleadoDto MapEmpleadoDto(String row) {
		String[] empleadoRow=row.split(";");
		EmpleadoDto empleado= new EmpleadoDto();
		empleado.setTipoDocumento(TipoDocumento.valueOf(empleadoRow[0]));
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmpleadoDto>> violations =validator.validate(empleado);
		for (ConstraintViolation<EmpleadoDto> violation : violations) {
		    System.out.println(violation.getMessage()); 
		}
		return null;
	}
}
