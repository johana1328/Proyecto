package com.cmc.gestion.talento.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;

public interface SolicitudPersonalDao extends JpaRepository<SolicitudDePersonal, Long>{

}
