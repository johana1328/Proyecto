package com.cmc.gestion.talento.jpa.type;

public enum TipoArea {
	INGENIERIA("Ingenieria"), INFRA("infraestructura"), 
	MANTENIMIENTO("Mantenimiento"), GERENCIA("Gerencia") ,
	RRHH("Recursos humanos"), ADMIN("Administrativo y financiara");
	
	private String value;
	
	 private TipoArea (String value) { this.value = value; }
	 public String getValue() { return value; }
}
