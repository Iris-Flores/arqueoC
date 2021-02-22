package com.coopsanmartin.arqueo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cortes")
public class Corte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoCorte;
	@Column(length = 100)
	private String descripcionCorte;
	private Double Valor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@PrePersist
	public void prepersisit() {
		fechaRegistro = new Date();
	}
	
	public Corte() {
		super();
	}

	public Corte(String descripcionCorte, Double valor, Date fechaRegistro) {
		super();
		this.descripcionCorte = descripcionCorte;
		Valor = valor;
		this.fechaRegistro = fechaRegistro;
	}


	public int getCodigoCorte() {
		return codigoCorte;
	}

	public void setCodigoCorte(int codigoCorte) {
		this.codigoCorte = codigoCorte;
	}

	public String getDescripcionCorte() {
		return descripcionCorte;
	}

	public void setDescripcionCorte(String descripcionCorte) {
		this.descripcionCorte = descripcionCorte;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	private static final long serialVersionUID = 1L;

}
