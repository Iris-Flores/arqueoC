package com.coopsanmartin.arqueo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopsanmartin.arqueo.model.TipoDeCambio;
import com.coopsanmartin.arqueo.repository.TipoCambio;

@Service
public class TipoCambioService {

	@Autowired
	TipoCambio tipoCambio;

	public List<TipoDeCambio> findAll() {
		return (List<TipoDeCambio>) tipoCambio.findAll();
	}

	public TipoDeCambio findById(Integer id) {
		return tipoCambio.findById(id).orElse(null);
	}

	public TipoDeCambio save(TipoDeCambio cambio) {
		return tipoCambio.save(cambio);
	}

	public void delete(Integer id) {
		tipoCambio.deleteById(id);
	}
	
}
