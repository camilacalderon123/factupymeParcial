package com.soltec.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	

	@Id
	private String cufe;

	private byte estado;

	
	private Date fechaExpedicion;

	
	
	private Date fechaVencimiento;

	
	private String firma;

	
	private double totalDescuento;

	
	private double valorNeto;

	
	private List<DetalleFactura> detalleFacturas;

	
	private List<Documento> documentos;

	
	private Cliente cliente;

	
	private Empresa empresa;


	private RangoNumeracion rangoNumeracionBean;

	
	private List<Nota> notas;

	public Factura() {
	}

	public String getCufe() {
		return this.cufe;
	}

	public void setCufe(String cufe) {
		this.cufe = cufe;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFechaExpedicion() {
		return this.fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFirma() {
		return this.firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public double getTotalDescuento() {
		return this.totalDescuento;
	}

	public void setTotalDescuento(double totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

	public double getValorNeto() {
		return this.valorNeto;
	}

	public void setValorNeto(double valorNeto) {
		this.valorNeto = valorNeto;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setFactura(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setFactura(null);

		return detalleFactura;
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Documento addDocumento(Documento documento) {
		getDocumentos().add(documento);
		documento.setFactura(this);

		return documento;
	}

	public Documento removeDocumento(Documento documento) {
		getDocumentos().remove(documento);
		documento.setFactura(null);

		return documento;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public RangoNumeracion getRangoNumeracionBean() {
		return this.rangoNumeracionBean;
	}

	public void setRangoNumeracionBean(RangoNumeracion rangoNumeracionBean) {
		this.rangoNumeracionBean = rangoNumeracionBean;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setFactura(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setFactura(null);

		return nota;
	}
	
}
