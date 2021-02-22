package com.coopsanmartin.arqueo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopsanmartin.arqueo.model.Oficina;
import com.coopsanmartin.arqueo.repository.OficinaRepository;

@Service
public class OficinaService {

	@Autowired
	OficinaRepository oficinaRepository;

	public List<Oficina> findAll() {
		return (List<Oficina>) oficinaRepository.findAll();
	}

	public Oficina findById(Integer id) {
		return oficinaRepository.findById(id).orElse(null);
	}

	public Oficina save(Oficina oficina) {
		return oficinaRepository.save(oficina);
	}

	public void delete(Integer id) {
		oficinaRepository.deleteById(id);
	}
}
