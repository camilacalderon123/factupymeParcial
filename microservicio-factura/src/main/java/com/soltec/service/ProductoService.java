package com.soltec.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.soltec.entities.Producto;
/*import com.soltec.entities.Usuario;*/

public interface ProductoService{
	
	public Iterable<Producto> findAll(); 
	
	public Page<Producto> findAll(Pageable pagebale);
	
	public Optional<Producto> findById(int codigo); 
	
	public Producto save(Producto producto);
	
	public void deleteById(int codigo);
}
