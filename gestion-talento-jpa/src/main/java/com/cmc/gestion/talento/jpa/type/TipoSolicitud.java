package com.cmc.gestion.talento.jpa.type;

public enum TipoSolicitud {
 PERSONAL("Solicitud de personal"),CARTA_LABORAL("Carta Laboral");
 
    private String value;
	
	private TipoSolicitud (String value) {this.value = value;}
	public String getValue() {return value;}
}
