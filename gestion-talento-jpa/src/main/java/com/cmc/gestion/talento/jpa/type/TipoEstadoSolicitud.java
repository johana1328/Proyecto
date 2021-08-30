package com.cmc.gestion.talento.jpa.type;

public enum TipoEstadoSolicitud {
	SOLICITUD_CREADA("Creada"), SOLICITUD_ASIGNADA("Asignada"), SOLICITUD_PROCESO("En Proceso"), SOLICITUD_CERRADA("Cerrada"), SOLICITUD_RACHAZADA("Rechazada");

	private String value;

	private TipoEstadoSolicitud(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
