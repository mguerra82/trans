package com.trans.apirest.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cat_productos")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_codigo")
	private Long codigo;
	@Column(name="prod_tipo")
	private Long tipo;
	@Column(name="prod_nombre",nullable = true, unique = true)
	@NotEmpty(message = "el nombre no debe estar vacio")
	private String nombre;
	@Column(name="prod_usuario_crea")
	private int usuario_crea;
	@Column(name="prod_fecha_crea")
	private Date fechaCrea;
	@Column(name="prod_estadoReg")
	private String estadoReg;
	
	
	
	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public Long getTipo() {
		return tipo;
	}



	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getUsuario_crea() {
		return usuario_crea;
	}



	public void setUsuario_crea(int usuario_crea) {
		this.usuario_crea = usuario_crea;
	}



	public Date getFechaCrea() {
		return fechaCrea;
	}



	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}



	public String getEstadoReg() {
		return estadoReg;
	}



	public void setEstadoReg(String estadoReg) {
		this.estadoReg = estadoReg;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 1L;

}
