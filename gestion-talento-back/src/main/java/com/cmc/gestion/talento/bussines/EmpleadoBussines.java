package com.cmc.gestion.talento.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.jpa.dao.EmpleadoDao;
import com.cmc.gestion.talento.jpa.entity.Empleado;

@Service
public class EmpleadoBussines {
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	
	public List<EmpleadoDto> getAllEmpleados(){
		return null;
	}
	
	
	
	public void getEmpleados() {
		List<Empleado> emp=  this.empleadoDao.findAll();
		for(Empleado in : emp) {
			System.out.println(in.getPrimerNombre());
		}
	}

}
