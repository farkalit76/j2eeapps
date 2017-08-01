/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.email;

import com.farkalit.file.JavaFileReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author 72010995
 */
public class SendEmails {

     public static void main(String[] args)
    {
        SendEmails email = new SendEmails();
        String subject = "DCWASA Daily Report";
        String dcwReport = JavaFileReader.getDCWReport();
        email.sendMail(subject, dcwReport);
    }
    public Properties mailing;
     
    public SendEmails()
    {
        this.mailing = PropertyFileReader.getProps();
    }
    
    public void sendMail(String subject, String reportMessage)
    {
        // Recipient's email ID needs to be mentioned.
        final String fromMail = mailing.getProperty("from.email");
        System.out.println("Starting to send EMail. fromMail:" + fromMail);
        final String toMail = mailing.getProperty("to.list.email");
        final String username = mailing.getProperty("email.server.username");
        final String password = mailing.getProperty("email.server.password");

        System.out.println("fromMail:"+fromMail+", toMail:"+toMail);
        // Assuming you are sending email through relay.jangosmtp.net
        String host = "10.195.10.12";//smtp.gmail.com";
        String port = "25";//"587";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try
        {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(fromMail));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toMail));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            //message.setText("Hello, this is sample for to check send email using JavaMailAPI ");
            message.setText(reportMessage);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        }
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
