package com.soltec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soltec.entities.RangoNumeracion;
import com.soltec.repository.RangoNumeracionRepository;

@Service
public class RangoNumeracionServiceImpl implements RangoNumeracionService{

	@Autowired
	private RangoNumeracionRepository rangoNumeracionRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<RangoNumeracion> findAll() {
		return rangoNumeracionRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<RangoNumeracion> findAll(Pageable pagebale) {
		return rangoNumeracionRepository.findAll(pagebale);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<RangoNumeracion> findById(Integer idNumeracion) {
		return rangoNumeracionRepository.findById(idNumeracion);
	}

	@Override
	@Transactional
	public RangoNumeracion save(RangoNumeracion rangoNumeracion) {
		return rangoNumeracionRepository.save(rangoNumeracion);
	}

	@Override
	@Transactional
	public void deleteById(Integer idNumeracion) {
		rangoNumeracionRepository.deleteById(idNumeracion);
	}

}
