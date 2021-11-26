package com.soltec.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soltec.entities.Factura;
import com.soltec.entities.Usuario;

public interface FacturaService{
	
	public Iterable<Factura> findAll(); 
	
	public Page<Factura> findAll(Pageable pagebale);
	
	public Optional<Factura> findById(String CUFE); 
	
	public Factura save(Factura factura);
	
	public void deleteById(String CUFE);
}
