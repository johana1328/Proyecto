package com.cmc.gestion.talento.bussines;

import java.util.ArrayList;
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

@Component
public class NotificationBussines {
	
	private static final Logger logger = LogManager.getLogger(NotificationBussines.class);
	
	@Autowired
	private Environment env;
	 
	
	public void notificacionCreacion(String destinatario) {
		NotificationClinetDto notificacion = new NotificationClinetDto();
		notificacion.setCorreoDestinatario(destinatario);
		notificacion.setAsunto("Creacion de usuario");
		notificacion.setTemplate("T001");
		notificacion.setTemplateLayout("GENERAL");
		List<Attachment> listAttachment = new ArrayList<>();
		Attachment attachment = new Attachment();
		attachment.setName("activacion");
		attachment.setPath("images/activacion.jpg");
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
