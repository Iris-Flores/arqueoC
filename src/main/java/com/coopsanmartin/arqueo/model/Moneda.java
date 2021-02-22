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
@Table(name = "monedas")
public class Moneda implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoMoneda;
	@Column(length = 10)
	private String abreviaturaMoneda;
	@Column(length = 40)
	private String descripcionMoneda;
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@PrePersist
	public void prepersist() {
		fechaRegistro = new Date();
	}

	public Moneda() {
	
	}

	public Moneda(String abreviaturaMoneda, String descripcionMoneda, Date fechaRegistro) {
		super();
		this.abreviaturaMoneda = abreviaturaMoneda;
		this.descripcionMoneda = descripcionMoneda;
		this.fechaRegistro = fechaRegistro;
	}
	
	public Integer getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(Integer codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getAbreviaturaMoneda() {
		return abreviaturaMoneda;
	}

	public void setAbreviaturaMoneda(String abreviaturaMoneda) {
		this.abreviaturaMoneda = abreviaturaMoneda;
	}

	public String getDescripcionMoneda() {
		return descripcionMoneda;
	}

	public void setDescripcionMoneda(String descripcionMoneda) {
		this.descripcionMoneda = descripcionMoneda;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	private static final long serialVersionUID = 1L;

}
