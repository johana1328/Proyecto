package com.cmc.gestion.talento.jpa.type;

public enum NivelEstudios {
	
	BACHILLER("Bachiller"),
	TECNICO("Técnico"),
	TECNOLOGO("Técnologo"),
	PROFESIONAL("Profesional");
	
	private String value;
	
	 private NivelEstudios (String value) { this.value = value; }
	 public String getValue() { return value; }
	
}
