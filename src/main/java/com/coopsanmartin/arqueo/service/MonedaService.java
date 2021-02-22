package com.coopsanmartin.arqueo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.coopsanmartin.arqueo.model.Moneda;
import com.coopsanmartin.arqueo.repository.MonedaRepository;


@Service
public class MonedaService {
	
	@Autowired
	MonedaRepository monedaRepository;
	
	public List<Moneda> findAll() {
		return (List<Moneda>) monedaRepository.findAll();
	}
	
	
	public Moneda findById(Integer id) {
		return monedaRepository.findById(id).orElse(null);
	}

	public Moneda save(Moneda moneda) {
		return monedaRepository.save(moneda);
	}

	
	public void delete(Integer id) {
		monedaRepository.deleteById(id);
	}

}
