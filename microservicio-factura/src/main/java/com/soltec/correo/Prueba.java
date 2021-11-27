package com.soltec.correo;

import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Factura;
import com.soltec.entities.Usuario;

import java.io.File;
import java.util.GregorianCalendar;

public class Prueba {

	public static void main(String[] args) {
		EnviarCorreo ec = new EnviarCorreo();
		File f = new File("soltec.png");

		ec.enviarCorreo("recibo.pdf", f,new Usuario("sanchez", "1234", "juansebasprada07@gmail.com", 1, (byte) 1,"sebastian", "Administrador"),new Factura("CUFEASDSDFASDFA3424534",  new GregorianCalendar(2021,
				11, 11).getTime(),new GregorianCalendar(2025, 11, 11).getTime(),
				 3, 45, (byte)1,"SebastianSanchez",1,1,1), new DetalleFactura(1, "CUFEDSA", 1, 1));

	}

}
