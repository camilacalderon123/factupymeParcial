package com.soltec.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.soltec.entities.Cliente;
import com.soltec.entities.Factura;
import com.soltec.entities.RangoNumeracion;


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

	public boolean enviarCorreo(String nombreArchivo, File img, Cliente cl, Factura factura, List<Factura> articulos, RangoNumeracion rg) {

		boolean creado = false;
		boolean enviado = false;

		String saludo = "Estimado(a) " + cl.getNombre() + ", ha recibido un DOCUMENTO ELECTR�NICO por parte de SolTec 2.0.\r\n"
				+ "Env�o que se efect�a mediante los sistemas de Facturaci�n Electr�nica del Proveedor Tecnol�gico SolTec, "
				+ "autorizado bajo la resoluci�n DIAN 000413 del 18 Enero del 2019.";
		
		String datosArchivos= "Adjunto en el correo se encuentra un Archivo .ZIP con los siguientes documentos:\r\n"
				+ "� Representaci�n gr�fica del comprobante con extensi�n .PDF\r\n"
				+ "� Contenedor Electr�nico con extensi�n .XML\r\n";
		
		String solicitudes = "Solicitamos que por favor revise el documento electr�nico y sus anexos e .\r\n\r\n"
				+ "Este E-mail ha sido enviado autom�ticamente por favor no responder a esta cuenta, "
				+ "de requerir cualquier aclaratoria o informaci�n adicional debe comunicarse directamente las direcciones de email o tel�fono"
				+ " de: SOLTEC 2.0.\r\n"
				+ "\r\n"
				+ "La informaci�n contenida en este E-mail es confidencial y solo puede ser utilizada por la persona o "
				+ "la empresa a la cual est� dirigido y/o por el emisor. Si por error recibe este mensaje, "
				+ "favor reenviarlo y borrar el mensaje recibido inmediatamente.";

		try {
			correo = new Correo("facturacionpyme123@gmail.com", nombreArchivo,"pyme12345", "", "",
					cl.getCorreo(), "�Hola! \n\n" + saludo +"\n\n" + datosArchivos + "\n\n" + solicitudes, factura.getCUFE()+";Factura electr�nica;SOLTEC 2.0");

			creado = generarPDF.generarPDF(nombreArchivo, img, cl, factura, articulos, rg);

			correo.setRutaArchivo(new File(nombreArchivo).toString());
			correo.setRutaArchivo1(new File(nombreArchivo).toString());
			System.out.println(new File(nombreArchivo).toString());

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
