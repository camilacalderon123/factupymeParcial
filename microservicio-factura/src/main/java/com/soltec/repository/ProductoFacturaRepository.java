package com.soltec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soltec.entities.Producto;

public interface ProductoFacturaRepository  extends JpaRepository<Producto,Integer>{

}
