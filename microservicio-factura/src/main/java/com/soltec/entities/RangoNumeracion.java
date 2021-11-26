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
	private int idNumeracion;

	private Date fechaResolucion;

	
	private int numeroActual;

	
	private int numeroDesde;

	
	private int numeroHasta;

	
	private int numeroResolucion;

	private String prefijo;

	private List<Factura> facturas;

	public RangoNumeracion() {
	}

	public int getIdNumeracion() {
		return this.idNumeracion;
	}

	public void setIdNumeracion(int idNumeracion) {
		this.idNumeracion = idNumeracion;
	}

	public Date getFechaResolucion() {
		return this.fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public int getNumeroActual() {
		return this.numeroActual;
	}

	public void setNumeroActual(int numeroActual) {
		this.numeroActual = numeroActual;
	}

	public int getNumeroDesde() {
		return this.numeroDesde;
	}

	public void setNumeroDesde(int numeroDesde) {
		this.numeroDesde = numeroDesde;
	}

	public int getNumeroHasta() {
		return this.numeroHasta;
	}

	public void setNumeroHasta(int numeroHasta) {
		this.numeroHasta = numeroHasta;
	}

	public int getNumeroResolucion() {
		return this.numeroResolucion;
	}

	public void setNumeroResolucion(int numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setRangoNumeracionBean(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setRangoNumeracionBean(null);

		return factura;
	}

}
