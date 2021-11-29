package com.soltec.correo;

import com.soltec.entities.Cliente;
import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Factura;
import com.soltec.entities.RangoNumeracion;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prueba {

	public static void main(String[] args) throws Exception {
		EnviarCorreo ec = new EnviarCorreo();

		// GenerarQRCode gc=new GenerarQRCode();

		File f = new File("soltec.png");

		Cliente cl = new Cliente(1193530328, "SolTEC", "Juan Sebastián Sánchez Prada", "Colombia", "N. de Santander",
				"Cucúta", "Av 0 # 0-78", "juansebasprada07@gmail.com", "3219810616", "Juridico", "Regimen", 1);

		Factura fa = new Factura("20211111SDSDFASDFA3424534", new GregorianCalendar(2021, 11, 11).getTime(),
				new GregorianCalendar(2025, 11, 11).getTime(), 3, 45, (byte) 1, "SebastianSanchez", 1, 1, 1);

		DetalleFactura df = new DetalleFactura(1, "CUFEDSA", 1, 1);
		RangoNumeracion rg = new RangoNumeracion(24551, new Date(), 1876401818, 24551, 50000, 20001, "FE");

		ec.enviarCorreo("recibo.pdf", f, cl, fa, df, rg);

		
		
		
		
		
		/*
		 * GenerarPDF gp = new GenerarPDF(); gp.generarPDF("recibo.pdf", f, new
		 * Cliente(1193530328, "SolTEC", "Angely Camila Calderón", "Colombia",
		 * "N. de Santander", "Cucúta", "Av 0 # 0-78", "juansebasprada07@gmail.com",
		 * "3219810616", "Juridico", "Regimen", 1), new
		 * Factura("CUFEASDSDFASDFA3424534", new GregorianCalendar(2021, 11,
		 * 11).getTime(), new GregorianCalendar(2025, 11, 11).getTime(), 3, 45, (byte)
		 * 1, "SebastianSanchez", 1, 1, 1), new DetalleFactura(1, "CUFEDSA", 1, 1), new
		 * RangoNumeracion(24551, new Date(), 1876401818, 24551, 50000, 20001, "FE"));
		 */

		/*
		 * String cufe ="";
		 * 
		 * cufe+=(""+ 1876 //NumFactura + convertirFecha(new Date()) // + 678934013
		 * //NIT factura); + "juridica" + "1193530328" + 1876);
		 * 
		 * 
		 * String sha1 = "";
		 * 
		 * sha1 = org.apache.commons.codec.digest.DigestUtils.sha1Hex( cufe );
		 * System.out.println( "The sha1 of \""+ cufe + "\" is:"); System.out.println(
		 * sha1 );
		 */

	}

	static String convertirFecha(Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYmmddHHMMss");
		return formatter.format(fecha);
	}
}
