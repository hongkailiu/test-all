package com.hongkailiu.test.app.mail;

/**
 * Created by hongkailiu on 2015-05-02.
 */
public abstract class EmailSender {

    public static final String GOOGLE_SMTP = "smtp.googlemail.com";
    public static final int SSH_SMTP_PORT = 465;

    public abstract void send(String username, String password, String from, String to,
        String subject, String message) throws Exception;
}
