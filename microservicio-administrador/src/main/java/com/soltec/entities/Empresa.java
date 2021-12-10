package com.soltec.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name = "empresa")
public class Empresa{

	
	private String correo_empresa;

	private String departamento;

	private String direccion;

	private String documento;

	private String municipio;

	@Id
	private int nit;

	
	private String nombre_representante;


	private String numero_documento;

	
	private String razon_social;

	private String telefono;

	
	private int tipo_documento;
	
	private String logo_empresa;

	public Empresa() {
	}

	public String getCorreo_empresa() {
		return correo_empresa;
	}

	public void setCorreo_empresa(String correo_empresa) {
		this.correo_empresa = correo_empresa;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombre_representante() {
		return nombre_representante;
	}

	public void setNombre_representante(String nombre_representante) {
		this.nombre_representante = nombre_representante;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(int tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getLogo_empresa() {
		return logo_empresa;
	}

	public void setLogo_empresa(String logo_empresa) {
		this.logo_empresa = logo_empresa;
	}

	
	
	
	


	

}