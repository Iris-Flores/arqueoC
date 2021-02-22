package com.coopsanmartin.arqueo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopsanmartin.arqueo.model.Corte;

@Repository
public interface CorteRepository extends JpaRepository<Corte, Integer>{

}
