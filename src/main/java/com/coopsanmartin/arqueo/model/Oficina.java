package com.coopsanmartin.arqueo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "oficinas")
public class Oficina {

	@Id
	private Integer codigoOficina;
	@Column(length = 100)
	private String descripcionOficina;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@PrePersist
	public void prepersist() {
		fechaRegistro = new Date();
	}

	public Oficina() {

	}

	public Oficina(String descripcionOficina, Date fechaRegistro) {
		super();
		this.descripcionOficina = descripcionOficina;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getCodigoOficina() {
		return codigoOficina;
	}

	public void setCodigoOficina(Integer codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	public String getDescripcionOficina() {
		return descripcionOficina;
	}

	public void setDescripcionOficina(String descripcionOficina) {
		this.descripcionOficina = descripcionOficina;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
