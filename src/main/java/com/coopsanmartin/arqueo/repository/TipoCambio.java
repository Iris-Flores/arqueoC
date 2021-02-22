package com.coopsanmartin.arqueo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coopsanmartin.arqueo.model.TipoDeCambio;

@Repository
public interface TipoCambio extends JpaRepository<TipoDeCambio, Integer>{

}
