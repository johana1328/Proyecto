package com.cmc.gestion.talento.jpa.type;

public enum RangoAnoExperiencia {
	
	RANGO_0("Sin experiencia"),
	RANGO_0_6("De 0 a 6 meses"), 
	RANGO_6_12("De 6 meses a 1 Año"),
	RANGO_12_24("De 1 Año a 2 Años"),
	RANGO_24 ("2 Años en adelante");
	
	private String value;
	
	 private RangoAnoExperiencia (String value) { this.value = value; }
	 public String getValue() { return value; }

}
