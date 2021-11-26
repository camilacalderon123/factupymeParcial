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

	
	private Factura factura;

	public Nota() {
	}

	public int getIdNota() {
		return this.idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
