package com.cmc.gestion.talento.web;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ModelResponse {
	
	private String mensaje;
	
	private TypeMessage typeMessage;
	
	@JsonInclude(Include.NON_NULL)
	private List<Object> listData;
	
	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	public ModelResponse(List<Object> listData, TypeMessage typeMessage, String mensaje) {
		this.listData=listData;
		this.typeMessage=typeMessage;
		this.mensaje=mensaje;
	}
	
    public ModelResponse(Object data, TypeMessage typeMessage, String mensaje) {
    	this.data=data;
		this.typeMessage=typeMessage;
		this.mensaje=mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public List<Object> getListData() {
		return listData;
	}
	public Object getData() {
		return data;
	}

	public TypeMessage getTypeMessage() {
		return typeMessage;
	}
	

}
