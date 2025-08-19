package com.veersa.emailer.service;

import com.veersa.emailer.dto.EmailRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailRequestDto request) {
        try {
            System.out.println("Sending email to: " + request.getTo()+
                    ", Subject: " + request.getSubject() +
                    ", Body: " + request.getBody());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getTo());
            message.setSubject(request.getSubject());
            message.setText(request.getBody());
            mailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException("unable to send mail",e);
        }
    }


}
