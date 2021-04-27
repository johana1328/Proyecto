package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.gestion.talento.jpa.entity.ParametriaDetalle;

public interface ParametriaDetalleDao extends JpaRepository<ParametriaDetalle, Long>{
    
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.TARIFA")
	List<ParametriaDetalle> listParametriaTarifa();
	
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.AMBIENTE")
	List<ParametriaDetalle> listParametriaAmbiente();
	
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.TIPO_PERFIL")
	List<ParametriaDetalle> listParametriaTipoPerfil();
	
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.ESPECIALIDAD")
	List<ParametriaDetalle> listParametriaEspecialidad();
	
	@Query("select p from ParametriaDetalle p where p.grupo = com.cmc.gestion.talento.jpa.type.TipoParametriaDetalle.CLASE_PERFIL")
	List<ParametriaDetalle> listParametriaClsePerfil();
	
	
	List<ParametriaDetalle> findByValor(String valor);
	
}
