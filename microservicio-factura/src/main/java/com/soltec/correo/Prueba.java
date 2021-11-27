package com.soltec.correo;

import javax.swing.ImageIcon;

import com.soltec.entities.Usuario;
import com.soltec.entities.Cliente;
import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Empresa;
import com.soltec.entities.Factura;
import com.soltec.entities.RangoNumeracion;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

public class Prueba {

	public static void main(String[] args) {
		GenerarPDF gp = new GenerarPDF();
		EnviarCorreo ec = new EnviarCorreo();
		File f = new File("soltec.png");

		ec.enviarCorreo("recibo.pdf", f,
				new Usuario("sanchez", "1234", "juansebasprada07@gmail.com", 1, (byte) 1, "sebastian", "Administrador"),
				new Factura("CUFEASDSDFASDFA3424534", (byte) 1, new GregorianCalendar(2021, 11, 11).getTime(),
						new GregorianCalendar(2025, 11, 11).getTime(), "SebastianSanchez", 3, 45, new Cliente(),
						new Empresa(), new RangoNumeracion()),
				new DetalleFactura());

	}

	Image getCurrentDirectory() {

		return new ImageIcon(getClass().getResource("satelite.jpg")).getImage();
	}

}
