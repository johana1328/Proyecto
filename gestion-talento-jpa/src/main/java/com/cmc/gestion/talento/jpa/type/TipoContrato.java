package com.cmc.gestion.talento.jpa.type;

public enum TipoContrato {
	TERMINO_FIJO("Fijo "),
	TERMINO_INDEFINIDO("Indefinido"), 
	OBRA_LABOR("Obra labor "),
	PRESTACION_SERVICIOS("Prestacion de servicios "),
	OCACIONAL_TRABAJO ("Otra labor ");
	
	private String value;
	
	 private TipoContrato (String value) { this.value = value; }
	 public String getValue() { return value; }
}
