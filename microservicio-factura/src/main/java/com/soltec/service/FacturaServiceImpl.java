package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.Factura;
/*import com.soltec.entities.Usuario;*/
import com.soltec.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Factura> findAll() {
		return facturaRepository.findAll();
	}
	@Override
	@Transactional(readOnly=true)
	public Page<Factura> findAll(Pageable pagebale) {
		return facturaRepository.findAll(pagebale);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}


}
