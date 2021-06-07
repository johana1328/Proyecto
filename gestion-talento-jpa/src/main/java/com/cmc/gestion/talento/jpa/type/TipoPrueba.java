package com.cmc.gestion.talento.jpa.type;

public enum TipoPrueba {
	TECNICA("Prueba tecnica"),
	P_SICOTECNICA("Prueba psicotecnica"),
	EVALUACION_DESEMPENO("Evaluacion de desempeno");
	
	private String value;
	
	private TipoPrueba (String value) {this.value = value;}
	public String getValue() {return value;}
	

}
