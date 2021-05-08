package com.cmc.gestion.talento.bussines.dto;

import com.cmc.gestion.talento.jpa.type.TipoArea;

public class EmpleadoDto extends UsuarioDto{
	
	private TipoArea area;
	private String jefe;
	
	public TipoArea getArea() {
		return area;
	}
	public void setArea(TipoArea area) {
		this.area = area;
	}
	public String getJefe() {
		return jefe;
	}
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

}
