package com.veersa.emailer.service;

import com.veersa.emailer.dto.EmailRequestDto;

public interface EmailService {


    void sendEmail(EmailRequestDto request);
}
