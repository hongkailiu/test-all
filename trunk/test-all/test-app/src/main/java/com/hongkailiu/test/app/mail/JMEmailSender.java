package com.hongkailiu.test.app.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by ehongka on 4/22/15.
 */
public class JMEmailSender extends EmailSender {

/*    public static void main(String[] args) {
        try {
            System.out.println("aaa");
            send("liutestlt@sina.com", "leadtone123", "liutestlt@sina.com", "", "title", "test");
            System.out.println("aaa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void send(String username, String password, String from, String to, String title, String message) throws
        Exception {
        //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", GOOGLE_SMTP);
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", String.valueOf(SSH_SMTP_PORT));
        props.setProperty("mail.smtp.socketFactory.port", String.valueOf(SSH_SMTP_PORT));
        props.setProperty("mail.smtps.auth", "true");

        /*
        If set to false, the QUIT command is sent and the connection is immediately closed. If set
        to true (the default), causes the transport to wait for the response to the QUIT command.

        ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
                http://forum.java.sun.com/thread.jspa?threadID=5205249
                smtpsend.java - demo program from javamail
        */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

        /*if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }*/

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        Transport t = session.getTransport("smtps");

        t.connect(GOOGLE_SMTP, username, password);
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
    }
}
