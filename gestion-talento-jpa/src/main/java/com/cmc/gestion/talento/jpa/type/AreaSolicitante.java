package com.cmc.gestion.talento.jpa.type;

public enum AreaSolicitante {
	
	FABRICA("Fabrica"),
	SERVICIOS_PROFESIONALES("Servicios Profesionales");
	
	private String value;
	
	 private AreaSolicitante (String value) { this.value = value; }
	 public String getValue() { return value; }

}
