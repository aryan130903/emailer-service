package com.veersa.emailer.consumer;

import com.veersa.emailer.dto.EmailRequestDto;
import com.veersa.emailer.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private final EmailService emailService;

    public RabbitMQConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(EmailRequestDto email) {
        System.out.println("📩 Received email request for: " + email.getTo());
        System.out.println("Subject: " + email.getSubject());
        System.out.println("Body: " + email.getBody());
        emailService.sendEmail(email);
    }
}
