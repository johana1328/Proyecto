package com.cmc.gestion.talento.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cmc.gestion.talento.jpa.entity.Usuario;
import com.cmc.gestion.talento.jpa.type.TipoPerfil;

public interface UsuarioDao extends PagingAndSortingRepository<Usuario, String> {
	
	@Query(value="SELECT * from usuario u "
			+ " inner join perfil_usuario pu on pu.id_usuario = u.id_usuario"
			+ " and pu.perfil != 'CANDIDATO'", nativeQuery = true)
	public List<Usuario> getUsuariosEmpleados();
	
	/*@Query(value="SELECT * from usuario u "
			+ " inner join perfil_usuario pu on pu.id_usuario = u.id_usuario"
			+ " and pu.perfil in('GERENTE','GERENTE_RRHH','DIRECTOR')", nativeQuery = true)*/
	//@Query(value="SELECT u from Usuario u where u.perfilUsuario.perfil in ('GERENTE')")
	//public List<Usuario> getGefes();
	
	public List<Usuario> findByPerfilUsuarioIn(List<TipoPerfil> tipoPerfil);
	
	
   
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
