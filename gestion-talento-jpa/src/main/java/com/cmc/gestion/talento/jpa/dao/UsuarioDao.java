package com.cmc.gestion.talento.jpa.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.cmc.gestion.talento.jpa.entity.Usuario;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, String> {
   
	/*public Optional<Usuario>  findByUsuarioAndContrasena(String usuario, String contrasena);
    
	@Query(value = "select * from us_usuario u "
			+ " inner  join us_perfil_usuario pu on pu.codigo_usuario = u.id_usuario "
			+ " inner  join us_perfil p on p.codigo_perfil = pu.codigo_perfil "
			+ " WHERE  u.usuario= :usuario and u.contrasena = :password" , nativeQuery = true )
	public Optional<Usuario> getUsuarioLogin(@Param("usuario") String usuario, @Param("password") String password);*/
	
	/*
	 * Querys creadas a pertir de metodos
	 * JPQL
	 * SQL
	 * slect * from Usuario where usuario= :usuario and contrasena= :contrasena
	 * */
	
	
}
