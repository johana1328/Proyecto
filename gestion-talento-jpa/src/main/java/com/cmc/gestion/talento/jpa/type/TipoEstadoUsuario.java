package com.cmc.gestion.talento.jpa.type;

public enum TipoEstadoUsuario {
	CREADO("Creado"), BLOQUEADO("Bloqueado"), ACTIVO("Activo"), RESET("Reset");
	
	  private String value;
	
	 private TipoEstadoUsuario(String value) { this.value = value; }
	 public String getValue() { return value; }
}
