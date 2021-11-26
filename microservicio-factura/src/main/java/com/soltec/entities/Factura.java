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
	private String CUFE;

	private Date fecha_expedicion;
	private Date fecha_vencimiento;	
	private double valor_neto;
	private double total_descuento;	
	private byte estado;
	private String firma;	
	private int empresa_NIT;
	private int rango_numeracion;
	private int cliente_numero_documento;
	/*private RangoNumeracion rangoNumeracionBean;*/
	public String getCUFE() {
		return CUFE;
	}
	public void setCUFE(String cUFE) {
		CUFE = cUFE;
	}
	public Date getFecha_expedicion() {
		return fecha_expedicion;
	}
	public void setFecha_expedicion(Date fecha_expedicion) {
		this.fecha_expedicion = fecha_expedicion;
	}
	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public double getValor_neto() {
		return valor_neto;
	}
	public void setValor_neto(double valor_neto) {
		this.valor_neto = valor_neto;
	}
	public double getTotal_descuento() {
		return total_descuento;
	}
	public void setTotal_descuento(double total_descuento) {
		this.total_descuento = total_descuento;
	}
	public byte getEstado() {
		return estado;
	}
	public void setEstado(byte estado) {
		this.estado = estado;
	}
	public String getFirma() {
		return firma;
	}
	public void setFirma(String firma) {
		this.firma = firma;
	}
	public int getEmpresa_NIT() {
		return empresa_NIT;
	}
	public void setEmpresa_NIT(int empresa_NIT) {
		this.empresa_NIT = empresa_NIT;
	}
	public int getRango_numeracion() {
		return rango_numeracion;
	}
	public void setRango_numeracion(int rango_numeracion) {
		this.rango_numeracion = rango_numeracion;
	}
	public int getCliente_numero_documento() {
		return cliente_numero_documento;
	}
	public void setCliente_numero_documento(int cliente_numero_documento) {
		this.cliente_numero_documento = cliente_numero_documento;
	}
	
	
	/*private List<DetalleFactura> detalleFacturas;

	
	private List<Documento> documentos;

	
	private Cliente cliente;

	
	private Empresa empresa;*/


	
	


	/*public List<DetalleFactura> getDetalleFacturas() {
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
	}*/

	
	
}
