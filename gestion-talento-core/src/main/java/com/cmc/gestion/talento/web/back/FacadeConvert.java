package com.cmc.gestion.talento.bussines.facade;

import java.util.ArrayList;
import java.util.List;

public abstract class FacadeConvert<T, K> {
	protected abstract T mapper(K entidad);

	public T getObject(K entidad) {
		return mapper(entidad);
	}

	public List<T> getListObject(List<K> entidades) {
		List<T> entidadesDto = new ArrayList<T>();
		for (K in : entidades) {
			T entidadDto = getObject(in);
			entidadesDto.add(entidadDto);
		}
		return entidadesDto;
	}
	
	public List<T> getListObject(Iterable<K> entidades) {
		List<T> entidadesDto = new ArrayList<T>();
		entidades.forEach(in->{
			T entidadDto = getObject(in);
			entidadesDto.add(entidadDto);
		});
		return entidadesDto;
	}

}
