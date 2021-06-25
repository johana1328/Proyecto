package com.cmc.gestion.talento.web.config;

public class ArqGestionExcepcion extends Exception{
	public enum ExcepcionType {ERROR_VALIDATION, ERRO_SECURITY}
	private ExcepcionType tipo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArqGestionExcepcion(String msg, ExcepcionType tipo){
		super(msg);
		this.tipo=tipo;
	}
	public ExcepcionType getTipo() {
		return tipo;
	}

}
