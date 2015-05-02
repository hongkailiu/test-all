package com.hongkailiu.test.app.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by hongkailiu on 2015-05-02.
 */
public class ACEmailSender extends EmailSender {
    @Override
    public void send(String username, String password, String from, String to,
        String subject, String message) throws Exception {
        Email email = new SimpleEmail();
        email.setHostName(GOOGLE_SMTP);
        email.setSmtpPort(SSH_SMTP_PORT);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSLOnConnect(true);
        email.setFrom(from);
        email.setSubject(subject);
        email.setMsg(message);
        email.addTo(to);
        email.send();
    }
}
