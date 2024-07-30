package com.project.Shop.service;

import com.project.Shop.dto.MailInfo;

import javax.mail.MessagingException;

public interface MailerService {
    void send(MailInfo mail) throws MessagingException;

    void queue(MailInfo mail);
}
