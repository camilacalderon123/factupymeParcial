package com.soltec.correo;

import java.io.File;
import java.util.Properties;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnviarMail {

    public boolean SendMail(Correo c) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(c.getUsuarioCorreo(), c.getContrasena());
                }
            };

            Session s = Session.getDefaultInstance(props, auth);
            BodyPart texto = new MimeBodyPart();
            texto.setText(c.getMensaje());
            BodyPart adjunto = new MimeBodyPart();
            if (!c.getRutaArchivo().equals("")) {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
                System.out.println(adjunto.getDataHandler());
                adjunto.setFileName(c.getNombreArchivo());
                System.out.println(adjunto.getFileName());
            }
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
            
            if (!c.getRutaArchivo().equals("")) {
                m.addBodyPart(adjunto);
            }
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
            InternetAddress[] toAddresses = { new InternetAddress(c.getDestino()) };
            mensaje.setRecipients(Message.RecipientType.TO, toAddresses);
           
            // mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
            mensaje.setSubject(c.getAdjunto());
            mensaje.setContent(m);

			Transport.send(mensaje); 

            return true;

        } catch (Exception e) {
        	System.out.println("spoa");
            return false;
        }
    }

    public void enviar(String destino, String mensaje) {

    	UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().split("-")[0];
    	System.out.println("a");
        String usuarioCorreo="facturacionpyme123@gmail.com";//correo
        String aux="pyme12345";//contraseña
        String nombreArchivo = "recibo.txt";
        //String mensaje = "Deseamos hacerle llegar los datos del animal";
        String adjunto = "FACTURACIÓN ELECTRÓNICA";
        File destinoArchivo = new File(nombreArchivo);
        String rutaArchivo = String.valueOf(destinoArchivo);

        Correo c = new Correo(usuarioCorreo, nombreArchivo, aux, rutaArchivo, destino, mensaje, adjunto);

        if (this.SendMail(c)) {
            JOptionPane.showMessageDialog(null, "Mensaje Enviado");
        } else {
            JOptionPane.showMessageDialog(null, "Mensaje no Enviado");
        }
    }
}