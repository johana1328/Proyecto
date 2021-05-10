package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.SubSerie;

public interface SubserieDao extends JpaRepository<SubSerie, Long>{
	List<SubSerie> findByNombre(String nombre);
	
	
}
