package com.cmc.gestion.talento.jpa.type;

public enum TipoDocumento {
   TI("Tarjeta de identidad"),
   CC("Cédula de ciudadania"),
   CE("Cédula de Extranjería"),
   PS("pasaporte");
	
	private String value;
	
	 private TipoDocumento (String value) { this.value = value; }
	 public String getValue() { return value; }
}
