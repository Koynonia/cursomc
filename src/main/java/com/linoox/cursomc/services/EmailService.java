package com.linoox.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.linoox.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
