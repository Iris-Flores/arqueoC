package com.coopsanmartin.arqueo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cambiosMon")
public class TipoDeCambio implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	private Double cambioDolar;

	@PrePersist
	public void prepersist() {
		fechaRegistro = new Date();
	}

	public TipoDeCambio() {

	}

	public TipoDeCambio(Date fechaRegistro, Double cambioDolar) {
		super();
		this.fechaRegistro = fechaRegistro;
		this.cambioDolar = cambioDolar;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Double getCambioDolar() {
		return cambioDolar;
	}

	public void setCambioDolar(Double cambioDolar) {
		this.cambioDolar = cambioDolar;
	}
	private static final long serialVersionUID = 1L;

}
