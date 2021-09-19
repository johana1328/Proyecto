package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.gestion.talento.jpa.entity.Solicitud;

public interface SolicitudDao extends JpaRepository<Solicitud, Long>{
	
	@Query("SELECT s FROM Solicitud s WHERE s.solicitante.idUsuario = ?1")
	List<Solicitud> findByGerente(String idUsuario);
	
	@Query("SELECT s FROM Solicitud s WHERE s.gestor.idUsuario = ?1")
	List<Solicitud> findByAnalista(String idUsuario);

}
