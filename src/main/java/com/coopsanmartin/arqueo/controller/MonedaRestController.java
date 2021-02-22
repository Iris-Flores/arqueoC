package com.coopsanmartin.arqueo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coopsanmartin.arqueo.model.Moneda;
import com.coopsanmartin.arqueo.service.MonedaService;


@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class MonedaRestController {
	
	@Autowired
	MonedaService monedaService;
	
	@GetMapping("/moneda")
	public List<Moneda> index (){
		return monedaService.findAll();
	}
	
	@GetMapping("/moneda/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Moneda moneda = null;
		Map<String, Object> response = new HashMap<>();
		try {
			moneda = monedaService.findById(id);			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(moneda == null) {
			response.put("mensaje", "la moneda con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Moneda>(moneda, HttpStatus.OK);
	}
	
	@PostMapping("/moneda/registrar")
	public ResponseEntity<?> create(@Validated @RequestBody Moneda moneda, BindingResult result){
		
		Moneda monedaNew = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "el campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			monedaNew = monedaService.save(moneda);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al insertar a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la moneda ha sido creada con éxito !");
		response.put("moneda", monedaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@PutMapping("/moneda/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Moneda moneda, BindingResult result, @PathVariable Integer id){
		Moneda monedaActual = monedaService.findById(id);
		Moneda monedaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (monedaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la moneda con ID : ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			monedaActual.setAbreviaturaMoneda(moneda.getAbreviaturaMoneda());
			monedaActual.setDescripcionMoneda(moneda.getDescripcionMoneda());
			
			monedaUpdated = monedaService.save(monedaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "La moneda ha sido actualizado con éxito!");
		response.put("moneda", monedaUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	@DeleteMapping("/moneda/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		Map<String, Object> response = new HashMap<>();
		try {
			Moneda moneda = monedaService.findById(id);
			
			monedaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La moneda fue eliminada con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
