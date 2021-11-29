package com.soltec.correo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

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
			BodyPart adjunto1 = new MimeBodyPart();

			convertirAXML("recibo.pdf");

			if (!c.getRutaArchivo().equals("") && !c.getRutaArchivo1().equals("")) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
				adjunto.setFileName(c.getNombreArchivo());

				adjunto1.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo1())));
				adjunto1.setFileName("recibo.xml");
			}
			MimeMultipart m = new MimeMultipart();
			m.addBodyPart(texto);

			if (!c.getRutaArchivo().equals("") && !c.getRutaArchivo1().equals("")) {
				m.addBodyPart(adjunto);
				m.addBodyPart(adjunto1);
			}
			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
			InternetAddress[] toAddresses = { new InternetAddress(c.getDestino()) };
			mensaje.setRecipients(Message.RecipientType.TO, toAddresses);

			// mensaje.addRecipient(Message.RecipientType.TO, new
			// InternetAddress(c.getDestino()));
			mensaje.setSubject(c.getAdjunto());
			mensaje.setContent(m);

			Transport.send(mensaje);

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void convertirAXML(String nombreArchivo) {
		Document document = new Document(nombreArchivo);
		document.save("recibo.xml", SaveFormat.MobiXml);
		document.close();
	}

	public void enviar(String destino, String mensaje) {

		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString().split("-")[0];
		System.out.println("a");
		String usuarioCorreo = "facturacionpyme123@gmail.com";// correo
		String aux = "pyme12345";// contraseña
		String nombreArchivo = "recibo.txt";
		// String mensaje = "Deseamos hacerle llegar los datos del animal";
		String adjunto = "FACTURACIÓN ELECTRÓNICA";
		File destinoArchivo = new File(nombreArchivo);
		String rutaArchivo = String.valueOf(destinoArchivo);

		Correo c = new Correo(usuarioCorreo, nombreArchivo, nombreArchivo, aux, rutaArchivo, rutaArchivo, destino,
				mensaje, adjunto);

		if (this.SendMail(c)) {
			JOptionPane.showMessageDialog(null, "Mensaje Enviado");
		} else {
			JOptionPane.showMessageDialog(null, "Mensaje no Enviado");
		}
	}
}