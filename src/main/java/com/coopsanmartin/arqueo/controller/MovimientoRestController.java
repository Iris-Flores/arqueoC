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

import com.coopsanmartin.arqueo.model.Movimiento;
import com.coopsanmartin.arqueo.service.MovimientoService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class MovimientoRestController {
	
	@Autowired
	MovimientoService movimientoService;
	
	@GetMapping("/movimiento")
	public List<Movimiento> index (){
		return movimientoService.findAll();
	}
	
	@GetMapping("/movimiento/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id){
		Movimiento mov = null;
		Map<String, Object> response = new HashMap<>();
		try {
			mov = movimientoService.findById(id);			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(mov == null) {
			response.put("mensaje", "la transacción con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Movimiento>(mov, HttpStatus.OK);
	}
	
	@PostMapping("/movimiento/registrar")
	public ResponseEntity<?> create(@Validated @RequestBody Movimiento mov, BindingResult result){
		
		Movimiento movNew = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "el campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			movNew = movimientoService.save(mov);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al insertar a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la transacción ha sido creada con éxito !");
		response.put("moneda", movNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@PutMapping("/movimiento/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Movimiento mov, BindingResult result, @PathVariable Integer id){
		Movimiento movActual = movimientoService.findById(id);
		Movimiento movUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream().map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		if (movActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la transacción con ID : ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			movActual.setCantidadBilletesMonedas(mov.getCantidadBilletesMonedas());
		
			
			movUpdated = movimientoService.save(movActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "La transaccion ha sido actualizado con éxito!");
		response.put("mov", movUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	@DeleteMapping("/movimiento/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		Map<String, Object> response = new HashMap<>();
		try {
			Movimiento mov = movimientoService.findById(id);
			
			movimientoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La transaccion fue eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}
