package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.DetalleFactura;
/*import com.soltec.entities.Usuario;*/
import com.soltec.repository.DetalleFacturaRepository;

public class DetalleFacturaServiceImpl {
	
	@Autowired
	private DetalleFacturaRepository facturaRepository;
	
	@Transactional(readOnly=true)
	public Iterable<DetalleFactura> findAll() {
		return facturaRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Page<DetalleFactura> findAll(Pageable pagebale) {
		return facturaRepository.findAll(pagebale);
	}

	@Transactional(readOnly=true)
	public Optional<DetalleFactura> findById(int id) {
		return facturaRepository.findById(id);
	}

	@Transactional
	public DetalleFactura save(DetalleFactura factura) {
		return facturaRepository.save(factura);
	}

	/*@Transactional
	public void deleteById(String CUFE) {
		facturaRepository.deleteById(CUFE);
	}*/
}
