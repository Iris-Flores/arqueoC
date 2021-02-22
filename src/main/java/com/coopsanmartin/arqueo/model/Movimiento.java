package com.coopsanmartin.arqueo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movimiento")
public class Movimiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoTransaccion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTransaccion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	private Integer cantidadBilletesMonedas;

	@PrePersist
	public void prepersisit() {
		fechaTransaccion = new Date();
	}

	@PreUpdate
	public void preupdate() {
		fechaRegistro = new Date();
	}

	public Movimiento() {

	}

	public Movimiento(Date fechaTransaccion, Date fechaRegistro, Integer cantidadBilletesMonedas) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.fechaRegistro = fechaRegistro;
		this.cantidadBilletesMonedas = cantidadBilletesMonedas;
	}

	public Integer getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(Integer codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getCantidadBilletesMonedas() {
		return cantidadBilletesMonedas;
	}

	public void setCantidadBilletesMonedas(Integer cantidadBilletesMonedas) {
		this.cantidadBilletesMonedas = cantidadBilletesMonedas;
	}

	private static final long serialVersionUID = 1L;

}
