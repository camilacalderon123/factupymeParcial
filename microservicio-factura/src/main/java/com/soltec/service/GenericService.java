package com.soltec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService <T>{
	
	public Iterable<T> findAll(); 
	
	public Page<T> findAll(Pageable pagebale);
	
	public <E> T findById(E primary); 
	
	public T save(T factura);
	
	public <E> void deleteById(E primary);

}
