package com.hongkailiu.test.app.mail;

import org.junit.Test;

/**
 * Created by hongkailiu on 2015-05-02.
 */
public class EmailSenderIT {

    private EmailSender emailSender;

    @Test public void testSendAC() throws Exception {
        emailSender = new ACEmailSender();
        emailSender.send("liutestlt", "leadtone", "liutestlt@gmail.com", "liutestlt@gmail.com", "subject: apache common", "message");
    }

    @Test public void testSendJM() throws Exception {
        emailSender = new JMEmailSender();
        emailSender.send("liutestlt", "leadtone", "liutestlt@gmail.com", "liutestlt@gmail.com", "subject: java mail", "message");
    }
}
