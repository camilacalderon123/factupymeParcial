package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Producto;
/*import com.soltec.entities.Usuario;*/
import com.soltec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional(readOnly=true)
	public Iterable<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Page<Producto> findAll(Pageable pagebale) {
		return productoRepository.findAll(pagebale);
	}

	@Transactional(readOnly=true)
	public Optional<Producto> findById(int codigo) {
		return productoRepository.findById(codigo);
	}

	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void deleteById(int codigo) {
		// TODO Auto-generated method stub
		
	}

	/*@Transactional
	public void deleteById(String CUFE) {
		facturaRepository.deleteById(CUFE);
	}*/
}
