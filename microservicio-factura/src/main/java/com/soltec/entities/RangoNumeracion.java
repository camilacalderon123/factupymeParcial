package com.soltec.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rango_numeracion")
public class RangoNumeracion {

	@Id
	private int id_numeracion;

	private Date fecha_resolucion;
	private int numero_resolucion;
	private int numero_actual;
	private int numero_hasta;	
	private int numero_desde;
	private String prefijo;

	public RangoNumeracion() {
		super();
	}
	
	public RangoNumeracion(int id_numeracion, Date fecha_resolucion, int numero_resolucion, int numero_actual,
			int numero_hasta, int numero_desde, String prefijo) {
		super();
		this.id_numeracion = id_numeracion;
		this.fecha_resolucion = fecha_resolucion;
		this.numero_resolucion = numero_resolucion;
		this.numero_actual = numero_actual;
		this.numero_hasta = numero_hasta;
		this.numero_desde = numero_desde;
		this.prefijo = prefijo;
	}
	/*private List<Factura> facturas;*/
	public int getId_numeracion() {
		return id_numeracion;
	}
	public void setId_numeracion(int id_numeracion) {
		this.id_numeracion = id_numeracion;
	}
	public Date getFecha_resolucion() {
		return fecha_resolucion;
	}
	public void setFecha_resolucion(Date fecha_resolucion) {
		this.fecha_resolucion = fecha_resolucion;
	}
	public int getNumero_resolucion() {
		return numero_resolucion;
	}
	public void setNumero_resolucion(int numero_resolucion) {
		this.numero_resolucion = numero_resolucion;
	}
	public int getNumero_actual() {
		return numero_actual;
	}
	public void setNumero_actual(int numero_actual) {
		this.numero_actual = numero_actual;
	}
	public int getNumero_hasta() {
		return numero_hasta;
	}
	public void setNumero_hasta(int numero_hasta) {
		this.numero_hasta = numero_hasta;
	}
	public int getNumero_desde() {
		return numero_desde;
	}
	public void setNumero_desde(int numero_desde) {
		this.numero_desde = numero_desde;
	}
	public String getPrefijo() {
		return prefijo;
	}
	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	

}