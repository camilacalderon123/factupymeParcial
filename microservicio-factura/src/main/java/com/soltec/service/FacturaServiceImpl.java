package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Factura;
/*import com.soltec.entities.Usuario;*/
import com.soltec.repository.FacturaRepository;

public class FacturaServiceImpl {
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Transactional(readOnly=true)
	public Iterable<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Page<Factura> findAll(Pageable pagebale) {
		return facturaRepository.findAll(pagebale);
	}

	@Transactional(readOnly=true)
	public Optional<Factura> findById(String CUFE) {
		return facturaRepository.findById(CUFE);
	}

	@Transactional
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	/*@Transactional
	public void deleteById(String CUFE) {
		facturaRepository.deleteById(CUFE);
	}*/
}
