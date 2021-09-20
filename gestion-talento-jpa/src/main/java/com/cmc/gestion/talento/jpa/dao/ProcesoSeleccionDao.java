package com.cmc.gestion.talento.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccion;
import com.cmc.gestion.talento.jpa.entity.ProcesoSeleccionPk;

public interface ProcesoSeleccionDao extends JpaRepository<ProcesoSeleccion, ProcesoSeleccionPk>{

}
