package com.coopsanmartin.arqueo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopsanmartin.arqueo.model.Oficina;

@Repository
public interface OficinaRepository extends JpaRepository<Oficina, Integer>{

}
