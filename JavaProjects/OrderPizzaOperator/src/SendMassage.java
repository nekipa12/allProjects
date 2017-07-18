import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.handlers.message_rfc822;

public class SendMassage implements Runnable{

	private String mail;
	
	public SendMassage(String string) {
		this.mail = string;
	}

	@Override
	public void run() {
		String SMTP_AUTH_USER = "nekipa10@gmail.com";
		String SMTP_AUTH_PWD = "30111992andrey";
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", SMTP_AUTH_USER);
		props.put("mail.smtps.auth", "true");
		Session session = Session.getDefaultInstance(props);
		try {
			Transport t = session.getTransport();
			t.connect("smtp.gmail.com", 465, SMTP_AUTH_USER, SMTP_AUTH_PWD);
			MimeMessage m = new MimeMessage(session);
			m.setSubject("Order");
			m.setText("Ваш заказ подтверждён");
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			m.setSentDate(new Date());
			t.sendMessage(m, m.getRecipients(Message.RecipientType.TO));
			
			
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	

}
