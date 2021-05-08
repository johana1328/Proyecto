package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cmc.gestion.talento.jpa.entity.Serie;

public interface SerieDao extends JpaRepository<Serie, Long>{
	List<Serie> findByNombre(String nombre);
}
