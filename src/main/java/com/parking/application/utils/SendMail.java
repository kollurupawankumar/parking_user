package com.parking.application.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {


	/**
	 * This code is used to send OTP to the desired email
	 * @param to
	 * @param user
	 * @param randomNumber
	 * 
	 * @author Kolluru Pawan Kumar
	 */
    public static boolean sendEmail(String to, String user, String randomNumber)
    {
        final String username = "kollurupawankumar@gmail.com";
        final String password = "Subhi123#";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kollurupawankumar@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject("Parkwisely Registraction.. ");
            message.setText("Dear "+user+","
                + "\n\n Your OTP to activate your account :"+randomNumber);

            Transport.send(message);

            System.out.println("Done");
            return true;

        } 

        catch (MessagingException e) 
        {
        	e.printStackTrace();
            System.out.println("Username or Password are incorrect ... exiting !");
            return false;
        }
    }


    public static void main(String[] args) 
    {
        String to = "kollurupawankumar@gmail.com";
        sendEmail(to,"pawan","1234");
    }
}