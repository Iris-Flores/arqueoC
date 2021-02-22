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

import com.coopsanmartin.arqueo.model.Corte;
import com.coopsanmartin.arqueo.service.CorteService;



@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class CorteRestController {
	@Autowired
	CorteService corteService;
	
	@GetMapping("/corte")
	public List<Corte> index (){
		return corteService.findAll();
	}
	
	@GetMapping("/corte/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Corte corte = null;
		Map<String, Object> response = new HashMap<>();
		try {
			corte = corteService.findById(id);			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(corte == null) {
			response.put("mensaje", "el corte con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Corte>(corte, HttpStatus.OK);
	}
	
	@PostMapping("/corte/registrar")
	public ResponseEntity<?> create(@Validated @RequestBody Corte corte, BindingResult result){
		
		Corte corteNew = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "el campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			corteNew = corteService.save(corte);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al insertar a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el corte ha sido creada con éxito !");
		response.put("moneda", corteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@PutMapping("/corte/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Corte corte, BindingResult result, @PathVariable Integer id){
		Corte corteActual = corteService.findById(id);
		Corte corteUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (corteActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el corte con ID : ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			corteActual.setDescripcionCorte(corte.getDescripcionCorte());
			corteActual.setValor(corte.getValor());
			
			corteUpdated = corteService.save(corteActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "El corte ha sido actualizado con éxito!");
		response.put("corte", corteUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	@DeleteMapping("/corte/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		Map<String, Object> response = new HashMap<>();
		try {
			Corte corte = corteService.findById(id);
			
			corteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El corte fue eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
