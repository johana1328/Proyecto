package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.Prueba;
import com.cmc.gestion.talento.jpa.entity.PruebaPregunta;

public interface PruebaPreguntaDao extends JpaRepository<PruebaPregunta, Long> {
	List<PruebaPregunta> findByEnunciado(String enunciado);
	List<PruebaPregunta> findByPrueba(Prueba prueba);

}
