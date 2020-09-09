package com.utils;

import java.util.Properties;
import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class sendEmailAttachment {
	
	// for example, smtp.mailgun.org
		private static final String SMTP_SERVER = "";
		private static final String USERNAME = "";
		private static final String PASSWORD = "";

		//Sender Email id
		private static final String EMAIL_FROM = "akshayshinde9192@gmail.com";
		//Comma Separated recipient email
		private static final String EMAIL_TO = "vishal.vyas@gmail.com, akshayshinde9192@gmail.com";
		//Comma Separated recipient email
		private static final String EMAIL_TO_CC = "";

		private static final String EMAIL_SUBJECT = "Test Send Email (ATTACHMENT)";
		private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";

		public static void main(String[] args) {

			Properties prop = System.getProperties();
			prop.put("mail.smtp.auth", "true");

			Session session = Session.getInstance(prop, null);
			Message msg = new MimeMessage(session);

			try {

				msg.setFrom(new InternetAddress(EMAIL_FROM));

				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO, false));

				msg.setSubject(EMAIL_SUBJECT);

				// text
				MimeBodyPart p1 = new MimeBodyPart();
				p1.setText(EMAIL_TEXT);

				// file
				MimeBodyPart p2 = new MimeBodyPart();
				FileDataSource fds = new FileDataSource(System.getProperty("user.dir")+"\\src\\test\\java\\com\\tickledMedia\\theAsianParent\\oneGo.java");
				p2.setDataHandler(new DataHandler(fds));
				p2.setFileName(fds.getName());

				Multipart mp = new MimeMultipart();
				mp.addBodyPart(p1);
				mp.addBodyPart(p2);

				msg.setContent(mp);

				SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

				// connect
				t.connect(SMTP_SERVER, USERNAME, PASSWORD);

				// send
				t.sendMessage(msg, msg.getAllRecipients());

				System.out.println("Response: " + t.getLastServerResponse());

				t.close();

			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}

}
