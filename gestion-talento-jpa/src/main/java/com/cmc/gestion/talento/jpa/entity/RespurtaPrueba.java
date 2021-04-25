package com.cmc.gestion.talento.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "respuesta_prueba")
public class RespurtaPrueba implements Serializable{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//	
//	
//	@Id
//	@Column(name = "respuesta_prueba")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@JoinColumn(name = "candidato", nullable = false,foreignKey = @ForeignKey(name = "slcan_fk", value = ConstraintMode.CONSTRAINT))
//	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Candidato candidato;
//	
//	@JoinColumn(name = "id_solicitud", nullable = false,foreignKey = @ForeignKey(name = "slrespSol_fk", value = ConstraintMode.CONSTRAINT))
//	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private SolicitudDePersonal solicitudDePersonal;
//	
//	
//	@JoinColumn(name = "id_actividad_proceso", nullable = false,foreignKey = @ForeignKey(name = "slActPro_fk", value = ConstraintMode.CONSTRAINT))
//	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private ActividadProcesoSeleccion ActividadProcesoSeleccion;
//	
//	@Column(name = "respuesta_libre", length = 500)
//	private String respuestaLibre;
//	
//	@Column(name = "documento", length = 500)
//	private String documento;
//	
//	@Column(name = "id_opcion")
//	private int idOpcion;
//
//	public ActividadProcesoSeleccion getActividadProcesoSeleccion() {
//		return ActividadProcesoSeleccion;
//	}
//
//	public void setActividadProcesoSeleccion(ActividadProcesoSeleccion actividadProcesoSeleccion) {
//		ActividadProcesoSeleccion = actividadProcesoSeleccion;
//	}
//
//	public String getRespuestaLibre() {
//		return respuestaLibre;
//	}
//
//	public void setRespuestaLibre(String respuestaLibre) {
//		this.respuestaLibre = respuestaLibre;
//	}
//
//	public String getDocumento() {
//		return documento;
//	}
//
//	public void setDocumento(String documento) {
//		this.documento = documento;
//	}
//
//	public int getIdOpcion() {
//		return idOpcion;
//	}
//
//	public void setIdOpcion(int idOpcion) {
//		this.idOpcion = idOpcion;
//	}
//	
}
