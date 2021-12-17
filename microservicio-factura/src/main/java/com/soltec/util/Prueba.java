/*package com.soltec.util;

import co.edu.ufps.facturacion.entities.Cliente;
import co.edu.ufps.facturacion.entities.DetalleFactura;
import co.edu.ufps.facturacion.entities.Empresa;
import co.edu.ufps.facturacion.entities.Factura;
import co.edu.ufps.facturacion.entities.Producto;
import co.edu.ufps.facturacion.entities.RangoNumeracion;
import co.edu.ufps.facturacion.entities.TipoDocumento;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class Prueba {

	public static void main(String[] args) throws Exception {
		EnviarCorreo ec = new EnviarCorreo();

		// GenerarQRCode gc=new GenerarQRCode();

		File f = new File("soltec.png");

		
		File ff = new File(System.getProperty("user.dir")+"/recibo.pdf");
		System.out.println(ff.exists());
		System.out.println(ff.toString());
		System.out.println(System.getProperty("user.dir"));
		
		
		*/
		/*
		 * Cliente cl = new Cliente(1193530328, "C�cuta", "Natural",
		 * "juansebasprada07@gmail.com", "N. de Santander", "Av 7a #4-99", (byte) 1,
		 * "Juan Sebasti�n S�nchez Prada", "Juan Sebasti�n S�nchez Prada", "Colombia",
		 * "Com�n", "3219810616", new TipoDocumento(2, "C�dula de ciudadan�a (CC)"));
		 * Empresa em = new Empresa(60306735, "juansebasprada07@gmail.com",
		 * "N. de Santander", "Av 7a #4-99", "1193530328", "soltec.png", "C�cuta",
		 * "Juan Sebasti�n S�nchez Prada", "1193530328", "SA", "5846589", new
		 * TipoDocumento(2, "C�dula de ciudadan�a (CC)")); RangoNumeracion rg = new
		 * RangoNumeracion(24551, new GregorianCalendar(2021, 9, 11).getTime(), 24551,
		 * 20001, 50000, 1876401818, "FE"); Factura fa = new
		 * Factura("CUFEASDSDFASDFA3424534", (byte) 1, new GregorianCalendar(2021, 11,
		 * 11).getTime(), new GregorianCalendar(2025, 11, 11).getTime(),
		 * "Sebastian Sanchez", 3, 450.000, cl, em, rg);
		 * 
		 * Producto p = new Producto(5624, "Colecci�n de jordan", (byte) 1, 3,
		 * "Air jordan", 5, "CM", 830.000); DetalleFactura df = new DetalleFactura(1, 1,
		 * fa, p);
		 * 
		 * ec.enviarCorreo("recibo.pdf", f, cl, fa, df, rg);
		 */

		/*
		 * System.out.println("bud"); System.out.println("nomrbe archivo "); Document
		 * document = new Document("recibo.pdf");
		 * System.out.println(document.getFileName()); document.save("recibo.xml",
		 * SaveFormat.MobiXml); System.out.println("bueno ac�"); document.close();
		 */
		/*
		 * GenerarPDF gp = new GenerarPDF(); gp.generarPDF("recibo.pdf", f,
		 * cl,fa,df,rg);
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

	/*}

	static String convertirFecha(Date fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYmmddHHMMss");
		return formatter.format(fecha);
	}
}*/
