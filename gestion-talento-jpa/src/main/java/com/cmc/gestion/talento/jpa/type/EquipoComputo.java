package com.cmc.gestion.talento.jpa.type;

public enum EquipoComputo {
	PORTATIL("Portatil "),
	ESCRITORIO("Escritorio"), 
	NINGUNO("Ningno");
	
	private String value;
	
	 private EquipoComputo (String value) { this.value = value; }
	 public String getValue() { return value; }
}
