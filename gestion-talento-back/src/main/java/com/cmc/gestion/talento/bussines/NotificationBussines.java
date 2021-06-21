package com.cmc.gestion.talento.bussines;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cmc.gestion.talento.web.client.Attachment;
import com.cmc.gestion.talento.web.client.NotificationClinetDto;
import com.cmc.gestion.talento.web.client.Parametro;

@Component
public class NotificationBussines {
	
	private static final Logger logger = LogManager.getLogger(NotificationBussines.class);
	private static final String DATE_FORMAT="dd/MM/yyyy";
	private static final String HOURS_FORMAT="HH:mm";
	
	@Autowired
	private Environment env;
	 
	
	public void notificacionCreacion(String destinatario, String usuario, String password) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		SimpleDateFormat hourFormat = new SimpleDateFormat(HOURS_FORMAT);
		String fecha = dateFormat.format(new Date());
		String hora = hourFormat.format(new Date());
		
		NotificationClinetDto notificacion = new NotificationClinetDto();
		notificacion.setCorreoDestinatario(destinatario);
		notificacion.setAsunto("Creacion de usuario");
		notificacion.setTemplate("T004");
		notificacion.setTemplateLayout("NORMAL");
		List<Parametro> parametros = new ArrayList<>();
		parametros.add(new Parametro("fechaCrea", fecha));
		parametros.add(new Parametro("hora", hora));
		parametros.add(new Parametro("usuario", usuario));
		parametros.add(new Parametro("passwor", password));
		parametros.add(new Parametro("aplicativo", env.getProperty("com.cmc.confirmacion.url")));
		notificacion.setParametros(parametros);
		List<Attachment> listAttachment = new ArrayList<>();
		Attachment attachment = new Attachment();
		attachment.setName("creacionusua");
		attachment.setPath("images/creacionusua.jpg");
		attachment.setType("INLINE");
		listAttachment.add(attachment);
		notificacion.setAttachment(listAttachment);
		sendNotification(notificacion);   
	} 
	
	
	public void resetpassword(String destinatario, String usuario, String password) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		SimpleDateFormat hourFormat = new SimpleDateFormat(HOURS_FORMAT);
		String fecha = dateFormat.format(new Date());
		String hora = hourFormat.format(new Date());
		
		NotificationClinetDto notificacion = new NotificationClinetDto();
		notificacion.setCorreoDestinatario(destinatario);
		notificacion.setAsunto("Restablecimiento de usuario ");
		notificacion.setTemplate("T005");
		notificacion.setTemplateLayout("NORMAL");
		List<Parametro> parametros = new ArrayList<>();
		parametros.add(new Parametro("fechaCrea", fecha));
		parametros.add(new Parametro("hora", hora));
		parametros.add(new Parametro("usuario", usuario));
		parametros.add(new Parametro("passwor", password));
		parametros.add(new Parametro("aplicativo", env.getProperty("com.cmc.confirmacion.url")));
		notificacion.setParametros(parametros);
		List<Attachment> listAttachment = new ArrayList<>();
		Attachment attachment = new Attachment();
		attachment.setName("creacionusua");
		attachment.setPath("images/creacionusua.jpg");
		attachment.setType("INLINE");
		listAttachment.add(attachment);
		notificacion.setAttachment(listAttachment);
		sendNotification(notificacion);  
	} 
	
	
public void xxxxxx(String destinatario) {
		NotificationClinetDto notificacion = new NotificationClinetDto();
		notificacion.setCorreoDestinatario(destinatario);
		notificacion.setAsunto("Creacion de usuario");
		notificacion.setTemplate("T001");
		notificacion.setTemplateLayout("GENERAL");
		List<Attachment> listAttachment = new ArrayList<>();
		Attachment attachment = new Attachment();
		attachment.setName("activacion");
		attachment.setPath("images/creacionusua.jpg");
		attachment.setType("INLINE");
		listAttachment.add(attachment);
		notificacion.setAttachment(listAttachment);
		sendNotification(notificacion);
	} 
	
	
	private void sendNotification(NotificationClinetDto notificationClinetDto) {
		try {
			HttpHeaders headers  = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String url = env.getProperty("com.cmc.notification.url");
			HttpEntity<NotificationClinetDto> request = new HttpEntity<>(notificationClinetDto);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(url, request,  Object[].class);
		}catch (Exception e) {
			logger.error("Error al enviar mensajeria "+e.getMessage());
		}
	
	}

}
