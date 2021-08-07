package com.cmc.gestion.talento.jpa.type;

public enum TipoHerramientaPlataformaTecnologia {
	
	LENGUAJES("Lenguajes "),
	BASE_DATOS("Base de datos"),
	TECNOLOGIAS("Tecnologias"),
	HERRAMIENTAS("Herramientas"),
	SISTEMAS_OPERATIVOS("Sistemas Operativos"),
	OTROS("Otros");

	private String value;
	
	 private TipoHerramientaPlataformaTecnologia (String value) { this.value = value; }
	 public String getValue() { return value; }
}
