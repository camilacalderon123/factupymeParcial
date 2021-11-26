package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento {
	

	@Id
	private int idDocumentos;

	
	private String archivoPdf;

	
	private String descripcion;

	
	private Factura factura;

	public Documento() {
	}

	public int getIdDocumentos() {
		return this.idDocumentos;
	}

	public void setIdDocumentos(int idDocumentos) {
		this.idDocumentos = idDocumentos;
	}

	public String getArchivoPdf() {
		return this.archivoPdf;
	}

	public void setArchivoPdf(String archivoPdf) {
		this.archivoPdf = archivoPdf;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
