package com.soltec.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soltec.entities.DetalleFactura;
import com.soltec.entities.Factura;
/*import com.soltec.entities.Usuario;*/

public interface DetalleFacturaService{
	
	public Iterable<DetalleFactura> findAll(); 
	
	public Page<DetalleFactura> findAll(Pageable pagebale);
	
	public Optional<DetalleFactura> findById(int id_detalle); 
	
	public DetalleFactura save(DetalleFactura detalleFactura);
	
	public void deleteById(int id_detalle);
}
