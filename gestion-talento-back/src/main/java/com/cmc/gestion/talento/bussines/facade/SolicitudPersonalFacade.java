package com.cmc.gestion.talento.bussines.facade;

import java.util.ArrayList;
import java.util.List;

import com.cmc.gestion.talento.bussines.dto.AmbientacionDto;
import com.cmc.gestion.talento.bussines.dto.ClasePerfilDto;
import com.cmc.gestion.talento.bussines.dto.EmpleadoDto;
import com.cmc.gestion.talento.bussines.dto.EspecialidadDto;
import com.cmc.gestion.talento.bussines.dto.PerfilDto;
import com.cmc.gestion.talento.bussines.dto.SolicitudPersonalDto;
import com.cmc.gestion.talento.bussines.dto.TarifaDto;
import com.cmc.gestion.talento.jpa.entity.SolicitudDePersonal;
import com.cmc.gestion.talento.web.annotation.FacadeService;
import com.cmc.gestion.talento.web.back.FacadeConvert;

@FacadeService
public class SolicitudPersonalFacade extends FacadeConvert<SolicitudPersonalDto,SolicitudDePersonal> {

	@Override
	protected SolicitudPersonalDto mapper(SolicitudDePersonal entidad) {
		SolicitudPersonalDto solicitudPerson = new SolicitudPersonalDto();
		// datos solicitud
		solicitudPerson.setIdSolicitud(entidad.getIdSolicitud());
		EmpleadoDto emplado = new EmpleadoDto();
		emplado.setIdUsuario(entidad.getSolicitante().getIdUsuario());
		emplado.setPrimerNombre(entidad.getSolicitante().getPrimerNombre());
		emplado.setPrimerApellido(entidad.getSolicitante().getPrimerApellido());
		solicitudPerson.setSolicitante(emplado);
		solicitudPerson.setFechaCreacion(entidad.getFechaCreacion().getTime());
		solicitudPerson.setFechaActualizacion(entidad.getFechaActualizacion().getTime());
		solicitudPerson.setObservacionSolicitante(entidad.getObservacionSolicitante());
		solicitudPerson.setObservacionGestor(entidad.getObservacionGestor());
		solicitudPerson.setTipoSolicitud(entidad.getTipoSolicitud());
		solicitudPerson.setEstado(entidad.getEstado());
		solicitudPerson.setGestor(entidad.getGestor());
		
		solicitudPerson.setCliente(entidad.getCliente());
		solicitudPerson.setResponsableCliente(entidad.getResponsableCliente());
		solicitudPerson.setMesaTrabajo(entidad.getMesaTrabajo());
		solicitudPerson.setCaracteriSoftware(entidad.getCaracteriSoftware());
		solicitudPerson.setDescripcionPerfil(entidad.getDescripcionPerfil());
		solicitudPerson.setCantidadVacante(Integer.toString(entidad.getCantidadVacante()));
		solicitudPerson.setSalarioAsignado(Double.toString(entidad.getSalarioAsignado()));
		solicitudPerson.setHorasApagar(Integer.toString(entidad.getHorasApagar()));
		solicitudPerson.setFechaInicio(entidad.getFechaInicio().getTime());
	
		solicitudPerson.setTipoContrato(entidad.getTipoContrato());
		solicitudPerson.setEquipoComputo(entidad.getEquipoComputo());
		solicitudPerson.setEscolaridad(entidad.getEscolaridad());
		solicitudPerson.setAnoExperienciaMin(entidad.getAnoExperienciaMin());
		solicitudPerson.setAreaSolicitante(entidad.getAreaSolicitante());
		
		PerfilDto perfil = new PerfilDto();
		perfil.setCodigoPerfil(Long.toString(entidad.getPerfil().getId()));
		perfil.setNombre(entidad.getPerfil().getValor());
		solicitudPerson.setCodigoPerfil(entidad.getPerfil().getId());
		solicitudPerson.setPerfil(perfil);
		EspecialidadDto especialidad= new EspecialidadDto();
		especialidad.setId(entidad.getEspecialidad().getId());
		especialidad.setEspecialidad(entidad.getEspecialidad().getNombre());
		solicitudPerson.setCodigoEspecialidad(entidad.getEspecialidad().getId());
		solicitudPerson.setEspecialidad(especialidad);
		ClasePerfilDto clasePerfil = new ClasePerfilDto();
		clasePerfil.setId(entidad.getClasePerfil().getId());
		clasePerfil.setClaseperfil(entidad.getClasePerfil().getNombre());
		solicitudPerson.setCodClasePerfil(entidad.getClasePerfil().getId());
		solicitudPerson.setClasePerfil(clasePerfil);
		TarifaDto tarifa = new TarifaDto();
		tarifa.setId(entidad.getTarifa().getId());
		tarifa.setValor(entidad.getTarifa().getValor());
		solicitudPerson.setCodTarifa(Long.toString(entidad.getTarifa().getId()));
		solicitudPerson.setTarifa(tarifa);
		List<AmbientacionDto> grupoAmbientacion= new ArrayList<AmbientacionDto>();
		List<Long> codAmbientacion = new ArrayList<Long>();
		entidad.getGrupoAmbientacion().forEach(ga->{
			AmbientacionDto ega= new AmbientacionDto();
			ega.setId(ga.getId());
			ega.setAmbiente(ga.getNombre());
			codAmbientacion.add(ga.getId());
			grupoAmbientacion.add(ega);
		});
		solicitudPerson.setGrupoAmbientacion(grupoAmbientacion);
		solicitudPerson.setCodAmbientacion(codAmbientacion);
		return solicitudPerson;
	}

}
