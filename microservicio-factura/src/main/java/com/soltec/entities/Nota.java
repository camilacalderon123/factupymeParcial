package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notas")
public class Nota {
	@Id
	private int idNota;


	private String descripcion;

	
	private String mensaje;

	
	private String factura_CUFE;


	public int getIdNota() {
		return idNota;
	}


	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getFactura_CUFE() {
		return factura_CUFE;
	}


	public void setFactura_CUFE(String factura) {
		this.factura_CUFE = factura;
	}


}
