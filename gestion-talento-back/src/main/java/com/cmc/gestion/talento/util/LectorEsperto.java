package com.cmc.gestion.talento.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;

public class LectorEsperto {

	public List<String> convertXlsToObject(File file) throws ArqGestionExcepcion {
		List<String> registros = new ArrayList<>();
		try {
			FileInputStream fileInStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(fileInStream);
			XSSFSheet selSheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = selSheet.iterator();
			int contLinea = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (contLinea != 0) {
					Iterator<Cell> cellIterator = row.cellIterator();
					StringBuffer stringBuffer = new StringBuffer();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (stringBuffer.length() != 0) {
							stringBuffer.append(";");
						}
						stringBuffer.append(getValue(cell));
					}
					registros.add(stringBuffer.toString());
				}
				contLinea++;
			}
			workBook.close();
		} catch (IOException e) {
			throw new ArqGestionExcepcion("Error al leer el archivo", ExcepcionType.ERROR_VALIDATION);
		} catch (Exception e) {
			throw new ArqGestionExcepcion("Error al leer el archivo", ExcepcionType.ERROR_VALIDATION);
		}

		return registros;
	}

	private String getValue(Cell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.format("%.0f", cell.getNumericCellValue());
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return Boolean.toString(cell.getBooleanCellValue());
		default:
			return null;
		}
	}

}
