package com.coopsanmartin.arqueo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopsanmartin.arqueo.model.Corte;
import com.coopsanmartin.arqueo.repository.CorteRepository;

@Service
public class CorteService {

	@Autowired
	CorteRepository corteRepository;

	public List<Corte> findAll() {
		return (List<Corte>) corteRepository.findAll();
	}

	public Corte findById(Integer id) {
		return corteRepository.findById(id).orElse(null);
	}

	public Corte save(Corte corte) {
		return corteRepository.save(corte);
	}

	public void delete(Integer id) {
		corteRepository.deleteById(id);
	}

}
