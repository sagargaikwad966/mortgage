package com.hcl.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	private JavaMailSender mailSender;

	@Autowired
	public NotificationService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendOffersMail(String email, String offerList) throws MailException
	{	
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("sagargaikwad966@gmail.com");
		msg.setSubject("LOAN OFFERS");
		msg.setTo("sagar.gaikwad@hcl.com");
		msg.setText(offerList);
		
        	
        mailSender.send(msg);
  
	}
	
	

}
