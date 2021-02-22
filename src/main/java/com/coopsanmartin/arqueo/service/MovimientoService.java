package com.coopsanmartin.arqueo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopsanmartin.arqueo.model.Movimiento;
import com.coopsanmartin.arqueo.repository.MovimientoRepository;


@Service
public class MovimientoService {
	
	@Autowired
	MovimientoRepository movimientoRepository;
	
	public List<Movimiento> findAll() {
		return (List<Movimiento>) movimientoRepository.findAll();
	}
	
	
	public Movimiento findById(Integer id) {
		return movimientoRepository.findById(id).orElse(null);
	}

	public Movimiento save(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}

	
	public void delete(Integer id) {
		movimientoRepository.deleteById(id);
	}

}
