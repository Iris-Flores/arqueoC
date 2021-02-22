package com.coopsanmartin.arqueo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioId;
	@Column(unique = true, length = 30)
	private String nombreUsuario;
	@Column(unique = true)
	private String ci;
	@Column(length = 60)
	private String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistroUser;
	private Boolean estado;

	private String nombres;
	private String apellidos;
	private String telefono;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_usuario", "id_rol" }) })
	private List<Rol> roles;

	public Usuario() {

	}

	public Usuario(String nombreUsuario, String ci, String password, Date fechaRegistroUser, Boolean estado,
			String nombres, String apellidos, String telefono, List<Rol> roles) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.ci = ci;
		this.password = password;
		this.fechaRegistroUser = fechaRegistroUser;
		this.estado = estado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.roles = roles;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistroUser() {
		return fechaRegistroUser;
	}

	public void setFechaRegistroUser(Date fechaRegistroUser) {
		this.fechaRegistroUser = fechaRegistroUser;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	private static final long serialVersionUID = 1L;

}
