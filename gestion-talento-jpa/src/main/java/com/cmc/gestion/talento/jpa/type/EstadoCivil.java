package com.cmc.gestion.talento.jpa.type;

public enum EstadoCivil {
	SOLTERO("Soltero"),
	CASADO("Casado"),
	UNION_LIBRE("Union Libre"),
	VIUDO("Viudo");
	
	private String value;
	
	 private EstadoCivil (String value) { this.value = value; }
	 public String getValue() { return value; }
}
