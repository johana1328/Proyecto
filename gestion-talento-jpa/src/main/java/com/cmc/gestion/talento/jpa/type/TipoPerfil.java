package com.cmc.gestion.talento.jpa.type;

public enum TipoPerfil {
	EMPLEADO("Empleado"),
	GERENTE("Gerente"),
	GERENTE_RRHH("Gerente RRHH"),
	ANALISTA_PRINCIPAL_RRHH("Analista Lider RRHH"),
	ANALISTA_RRHH("Analista RRHH"),
	DIRECTOR("Director"),
	CANDIDATO("Candidato");
	
	private String value;
	
	 private TipoPerfil (String value) { this.value = value; }
	 public String getValue() { return value; }
}
