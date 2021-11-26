package com.soltec.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.soltec.entities.RangoNumeracion;

public interface RangoNumeracionService {

	public Iterable<RangoNumeracion> findAll();
	
	public Page<RangoNumeracion> findAll(Pageable pagebale);
	
	public Optional<RangoNumeracion> findById(Integer idNumeracion); 
	
	public RangoNumeracion save(RangoNumeracion rangoNumeracion);
	
	public void deleteById(Integer idNumeracion);
}
