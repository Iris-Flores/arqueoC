package com.coopsanmartin.arqueo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopsanmartin.arqueo.model.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer>{
	
	

}
