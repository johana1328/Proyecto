package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.gestion.talento.jpa.entity.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, String>{

	
	@Query(value="SELECT u.* FROM Usuario u LEFT JOIN Empleado e " , nativeQuery = true)
	public List<Empleado> getAllEmpleados();
}
