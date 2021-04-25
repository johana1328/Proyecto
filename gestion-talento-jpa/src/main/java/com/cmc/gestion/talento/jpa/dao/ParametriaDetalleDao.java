package com.cmc.gestion.talento.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;

public interface ParametriaDetalleDao extends JpaRepository<ParametriaDetalle, Long>{
    
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.TARIFA")
	List<ParametriaDetalle> listParametriaTarifa();
	
	List<ParametriaDetalle> findByValor(String valor);
	
}
