package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notas")
public class Nota {
	@Id
	private int id_nota;

	private String descripcion;	
	private String mensaje;	
	private String factura_CUFE;
	
	public Nota() {
		super();
	}

	public Nota(int id_nota, String descripcion, String mensaje, String factura_CUFE) {
		super();
		this.id_nota = id_nota;
		this.descripcion = descripcion;
		this.mensaje = mensaje;
		this.factura_CUFE = factura_CUFE;
	}
	
	public int getId_nota() {
		return id_nota;
	}
	public void setId_nota(int id_nota) {
		this.id_nota = id_nota;
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
	public void setFactura_CUFE(String factura_CUFE) {
		this.factura_CUFE = factura_CUFE;
	}


}