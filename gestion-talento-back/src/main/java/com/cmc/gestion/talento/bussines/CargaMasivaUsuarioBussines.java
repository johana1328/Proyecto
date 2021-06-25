package com.cmc.gestion.talento.bussines;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.type.TipoArea;
import com.cmc.gestion.talento.jpa.type.TipoDocumento;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;
import com.cmc.gestion.talento.util.LectorEsperto;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion;
import com.cmc.gestion.talento.web.config.ArqGestionExcepcion.ExcepcionType;
import com.cmc.gestion.talento.web.gestiondoc.FilesStorageService;

@Service
public class CargaMasivaUsuarioBussines {

	@Autowired
	private EmpleadoBussines empleadoBussines;

	@Autowired
	private FilesStorageService filesStorageService;

	public void guardarArchivo(String file) throws ArqGestionExcepcion {
		LectorEsperto lector;
		List<EmpleadoDto> listaEmpleado= new ArrayList<>();
		List<String> listaError= new ArrayList<>();
		try {
			lector = new LectorEsperto();
			List<String> registros=lector.convertXlsToObject(filesStorageService.load(file).getFile());
			for(int i=0;i<registros.size();i++) {
				try {
					String registro=registros.get(i);
					if(registro.length() > 20) {
						EmpleadoDto empleado= MapEmpleadoDto(registros.get(i));
						listaEmpleado.add(empleado);
					}
				}catch (ArqGestionExcepcion e) {
					listaError.add(i+1+";"+e.getMessage());
				}
			}
		} catch (IOException e) {
			listaError.add("NO APLICA;Error Al leer el archivo");
		} catch (ArqGestionExcepcion e) {
			listaError.add("NO APLICA;"+e.getMessage());
		}
		
		if(listaError.size()==0) {
			for(EmpleadoDto in : listaEmpleado) {
				empleadoBussines.crearEmpleado(in);
			}
		}else {
			Resource fileResource=filesStorageService.createSimpleFile("error.csv");
			try {
				FileWriter errorWriter = new FileWriter(fileResource.getFile());
				for(String in : listaError) {
					errorWriter.write(in +"\n");
				}
				errorWriter.close();
				throw new ArqGestionExcepcion("Error al procesar informacion del archivo", ExcepcionType.ERROR_VALIDATION);
			} catch (IOException e) {
				throw new ArqGestionExcepcion("Error al procesar informacion del archivo", ExcepcionType.ERROR_VALIDATION);
			}
		}
		
		
	}

	private EmpleadoDto MapEmpleadoDto(String row) throws ArqGestionExcepcion {
		String[] empleadoRow = row.split(";");
		EmpleadoDto empleado = new EmpleadoDto();
		try {
			empleado.setTipoDocumento(TipoDocumento.valueOf(empleadoRow[0]));
			empleado.setDocumento(empleadoRow[1]);
			empleado.setPrimerNombre(empleadoRow[2]);
			empleado.setSegundoNombre(empleadoRow[3]);
			empleado.setPrimerApellido(empleadoRow[4]);
			empleado.setSegundoApellido(empleadoRow[5]);
			empleado.setCorreoElectronico(empleadoRow[6]);
			empleado.setTelefono(empleadoRow[7]);
			try {
				empleado.setArea(TipoArea.valueOf(empleadoRow[8]));
			}catch (Exception e) {
				throw new ArqGestionExcepcion("Error campo Area no valido", ExcepcionType.ERROR_VALIDATION);
			}
			
			empleado.setJefe(empleadoRow[9]);
			empleado.setIdUsuario(empleadoRow[10]);
			try {
				empleado.setPerfil(TipoPerfil.valueOf(empleadoRow[11]));
			}catch (Exception e) {
				throw new ArqGestionExcepcion("Error campo Tipo Usuario no valido", ExcepcionType.ERROR_VALIDATION);
			}
			
		} catch (ArqGestionExcepcion e) {
			throw e;
		}catch (Exception e) {
			throw new ArqGestionExcepcion("Error En el formato del registro", ExcepcionType.ERROR_VALIDATION);
		}

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmpleadoDto>> violations = validator.validate(empleado);
		for (ConstraintViolation<EmpleadoDto> violation : violations) {
			throw new ArqGestionExcepcion(violation.getMessage(), ExcepcionType.ERROR_VALIDATION);
		}
		
		empleadoBussines.validarEmpleado(empleado);
		
		return empleado;
	}

}
