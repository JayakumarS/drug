package com.drug.common;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	public static String sendOtpMail(String mailId,String userName,String otp) throws Exception {
			Email email = new Email();
			StringBuffer sb = new StringBuffer();
			String path = "";
			email.setFromEmailAddress("jayakumar@techinfy.in");
			String toMailAddress = mailId;
			String[] toEmailIds = toMailAddress.split(",");
			email.setToEmailAddress(toEmailIds);
			String logoImage = "https://visitorchek.com/assets/images/vc_logo_1.png";

	 		sb.append("<!DOCTYPE html>\r\n");
			sb.append(
					"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");

			sb.append("<head>\r\n");
			sb.append("<meta charset=\"UTF-8\">");

			sb.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
			sb.append("<meta name=\"x-apple-disable-message-reformatting\">");

			sb.append("<style>");
			sb.append(" table, td, div, h1, p {font-family: Arial, sans-serif;}\r\n");
			
			sb.append("</style>");
			sb.append("</head>");

			sb.append("<h1 style=\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\">Your OTP Number is</h1>");
			sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">"+otp+"</h2>");
			

			sb.append("</tr>");
			sb.append("</table>");

			sb.append("</td>");
			sb.append("</tr>");

			sb.append("</table>");
			sb.append("</td>");

			sb.append("</tr>");
			sb.append("</table>");

			sb.append("</body>");
			sb.append("</html>");

			email.setBodyHtml(sb.toString());
			email.setSubject("OTP Number");
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						sendMail(email, path);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}).start();

			return path;
		}
	
	
	public static String sendForgotPasswordMail(String mailId,String userName,String otp) throws Exception {
		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("jayakumar@techinfy.in");
		String toMailAddress = mailId;
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
		String logoImage = "https://visitorchek.com/assets/images/vc_logo_1.png";

 		sb.append("<!DOCTYPE html>\r\n");
		sb.append(
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");

		sb.append("<head>\r\n");
		sb.append("<meta charset=\"UTF-8\">");

		sb.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		sb.append("<meta name=\"x-apple-disable-message-reformatting\">");

		sb.append("<style>");
		sb.append(" table, td, div, h1, p {font-family: Arial, sans-serif;}\r\n");
		
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Dear "+userName+"</h1>");

		sb.append("<h1 style=\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\">Your New Password is</h1>");
		sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">"+otp+"</h2>");
		sb.append("<br>");
	//	sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">In case If you want to change the password like your wish.Kindly use the Change Password option in Top right corner in the Dashboard</h2>");
		

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("</td>");

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</body>");
		sb.append("</html>");

		email.setBodyHtml(sb.toString());
		email.setSubject("Password Confirmation Mail");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sendMail(email, path);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		return path;
	}
	
	public static String sendChangePasswordMail(String mailId,String userName) throws Exception {
		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("jayakumar@techinfy.in");
		String toMailAddress = mailId;
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
		String logoImage = "https://visitorchek.com/assets/images/vc_logo_1.png";

 		sb.append("<!DOCTYPE html>\r\n");
		sb.append(
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");

		sb.append("<head>\r\n");
		sb.append("<meta charset=\"UTF-8\">");

		sb.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		sb.append("<meta name=\"x-apple-disable-message-reformatting\">");

		sb.append("<style>");
		sb.append(" table, td, div, h1, p {font-family: Arial, sans-serif;}\r\n");
		
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Dear "+userName+"</h1>");

		sb.append("<h1 style=\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\">Your New Password has been changed.Kindly Utilize your new Paassword and Don't share it to anyone.</h1>");
	//	sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">"+otp+"</h2>");
		sb.append("<br>");
	//	sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">In case If you want to change the password like your wish.Kindly use the Change Password option in Top right corner in the Dashboard</h2>");
		

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("</td>");

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</body>");
		sb.append("</html>");

		email.setBodyHtml(sb.toString());
		email.setSubject("Password Confirmation Mail");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sendMail(email, path);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		return path;
	}
		
		
	public static void sendMail(Email email, String path) throws Exception {

			String host = "smtp.zoho.com";
			// Create properties for the Session
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "465");
			
			props.setProperty("mail.pop3.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.startssl.enable", "true");
			props.put("mail.smtp.starttls.enable", "true");

			// Get a session
			Session session = Session.getInstance(props);

			try {
				Transport bus = session.getTransport("smtp");

				bus.connect("smtp.zoho.com", "jayakumar@techinfy.in", "1a4F4S6bjXcD");
				Message msg = new MimeMessage(session);

				// Set message attributes
				msg.setFrom(new InternetAddress(email.getFromEmailAddress()));

				int n = email.getToEmailAddress().length;
				InternetAddress[] address = new InternetAddress[n];
				for (int i = 0; i < n; i++) {
					address[i] = new InternetAddress(email.getToEmailAddress()[i]);

				}
				msg.setRecipients(Message.RecipientType.TO, address);
				
//				  String toAddress = "sgopes@gmail.com"; InternetAddress[] toAddresses = {
//				  new  InternetAddress(toAddress) };
//				  msg.setRecipients(Message.RecipientType.BCC,  toAddresses);
				 
				
				if (email.getCcEmailAddress() != null) {
					int ccCount = email.getCcEmailAddress().length;
					InternetAddress[] ccAddress = new InternetAddress[ccCount];
					for (int i = 0; i < ccCount; i++) {
						ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
					}
					msg.setRecipients(Message.RecipientType.CC, ccAddress);
					
					
				}

				msg.setSubject(email.getSubject());
				msg.setSentDate(new Date());
				msg.setContent(email.getBodyHtml(), "text/html");
				msg.saveChanges();
				bus.sendMessage(msg, msg.getAllRecipients());
				bus.close();

			} catch (MessagingException mex) {
				mex.printStackTrace();
				while (mex.getNextException() != null) {
					Exception ex = mex.getNextException();
					ex.printStackTrace();
					if (!(ex instanceof MessagingException))
						break;
					else
						mex = (MessagingException) ex;
				}
				throw mex;
			} finally {
				System.out.println("mail core smtp Successfully");
			}
		}
	
}
