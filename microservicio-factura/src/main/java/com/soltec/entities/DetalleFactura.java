package com.soltec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="detalle_factura")
public class DetalleFactura {
	

	@Id
	private int id_detalle;

	private String factura_CUFE;
	private int producto_codigo;
	private int cantidad;

	public DetalleFactura(int id_detalle, String factura_CUFE, int producto_codigo, int cantidad) {
		super();
		this.id_detalle = id_detalle;
		this.factura_CUFE = factura_CUFE;
		this.producto_codigo = producto_codigo;
		this.cantidad = cantidad;
	}
	public int getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}
	public String getFactura_CUFE() {
		return factura_CUFE;
	}
	public void setFactura_CUFE(String factura_CUFE) {
		this.factura_CUFE = factura_CUFE;
	}
	public int getProducto_codigo() {
		return producto_codigo;
	}
	public void setProducto_codigo(int producto_codigo) {
		this.producto_codigo = producto_codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


}
 
