package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.Prueba;

public interface PruebaDao extends JpaRepository<Prueba, Long> {
	List<Prueba> findByNombre(String nombre);

}
