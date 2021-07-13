package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.PreguntaOpcion;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;


public interface PreguntaOpcionDao extends JpaRepository<PreguntaOpcion, Long>{

	List<PreguntaOpcion> findByOpcion(String opcion);
	List<PreguntaOpcion> findByPruebaPregunta(PruebaPregunta pruebaPregunta);
}
