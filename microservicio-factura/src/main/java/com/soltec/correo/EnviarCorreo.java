/* package com.soltec.correo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import com.soltec.entities.Factura;
import com.soltec.entities.Usuario;

public class EnviarCorreo {
	private Correo correo;
	private EnviarMail enviar;
	private GenerarPDF generarPDF;

	public EnviarCorreo() {
		super();
		this.generarPDF = new GenerarPDF();
		this.enviar = new EnviarMail();
	}

	public EnviarCorreo(Correo correo, EnviarMail enviar, GenerarPDF generarPDF) {
		super();
		this.correo = correo;
		this.enviar = enviar;
		this.generarPDF = generarPDF;
	}

	public boolean enviarCorreo(String nombreArchivo, File img, String nombreAnimal, Usuario us,
			Factura factura) {
		System.out.println("dadssada");
		boolean creado = false;
		boolean enviado = false;
		try {
			correo = new Correo("facturacionpym123@gmail.com", nombreArchivo, "pyme12345", "", us.getCorreo(),
					"\u001B[36m¡Hola! \nNos alegramos que hayas generado una factura en nuestro sitio web, en el siguiente archivo encontrarás los detalles de tu factura electrónica",
					"Factura electrónica");

			creado = generarPDF.generarPDF(nombreArchivo, img, nombreAnimal, us, factura);

			correo.setRutaArchivo(new File(nombreArchivo).toString());

			enviado = enviar.SendMail(correo);

		} catch (FileNotFoundException e) {
			System.err.println("FILENOFOUND");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOEXCEPTION");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("INTERRUPTED");
			e.printStackTrace();
		}
		return creado && enviado;
	}

	public Correo getCorreo() {
		return correo;
	}

	public void setCorreo(Correo correo) {
		this.correo = correo;
	}

	public EnviarMail getEnviar() {
		return enviar;
	}

	public void setEnviar(EnviarMail enviar) {
		this.enviar = enviar;
	}

	public GenerarPDF getGenerarPDF() {
		return generarPDF;
	}

	public void setGenerarPDF(GenerarPDF generarPDF) {
		this.generarPDF = generarPDF;
	}

}
*/
