package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cmc.gestion.talento.jpa.entity.Candidato;

public interface CandidatoDao extends JpaRepository<Candidato, String> {
	
	@Query(value="SELECT u.* FROM Usuario u LEFT JOIN Candidato ca " , nativeQuery = true)
	public List<Candidato> getAllCandidatos();
	
	List<Candidato> findByCorreoElectronico(String correoElectronico);
	List<Candidato> findByDocumento(String documento);
	
}
