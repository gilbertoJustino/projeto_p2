package Projeto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mensageiro {

    public static void enviarProgramacaoDeHoje(String destinatario) {

            Percistencia persistencia = new Percistencia();
            CentralDeInformacoes cdi = persistencia.recuperarCentral("central.xml");

            Properties props = new Properties();

            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication("giljssjustino@gmail.com", "********");
                        }
                    });

            session.setDebug(true);

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("giljssjustino@gmail.com"));

                Address[] toUser = InternetAddress.parse(destinatario);

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Programação de hoje");

                message.setText("Teste");

                Transport.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

    }
}
