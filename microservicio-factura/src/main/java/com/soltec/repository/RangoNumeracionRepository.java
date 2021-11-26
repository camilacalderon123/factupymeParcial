package com.soltec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soltec.entities.RangoNumeracion;

@Repository
public interface RangoNumeracionRepository extends JpaRepository<RangoNumeracion, Integer>{

}
