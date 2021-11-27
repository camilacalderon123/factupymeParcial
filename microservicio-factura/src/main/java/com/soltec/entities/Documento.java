package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento {
	
	@Id
	private int id_documentos;
	
	private String descripcion;	
	private String archivo_pdf;	
	private String factura_CUFE;

	public Documento(int id_documentos, String descripcion, String archivo_pdf, String factura_CUFE) {
		super();
		this.id_documentos = id_documentos;
		this.descripcion = descripcion;
		this.archivo_pdf = archivo_pdf;
		this.factura_CUFE = factura_CUFE;
	}
	public int getId_documentos() {
		return id_documentos;
	}
	public void setId_documentos(int id_documentos) {
		this.id_documentos = id_documentos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getArchivo_pdf() {
		return archivo_pdf;
	}
	public void setArchivo_pdf(String archivo_pdf) {
		this.archivo_pdf = archivo_pdf;
	}
	public String getFactura_CUFE() {
		return factura_CUFE;
	}
	public void setFactura_CUFE(String factura_CUFE) {
		this.factura_CUFE = factura_CUFE;
	}
	
}
