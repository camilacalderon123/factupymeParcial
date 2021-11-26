package com.soltec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soltec.entities.Factura;

public interface FacturaRepository  extends JpaRepository<Factura,Long>{

}
