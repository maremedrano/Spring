package com.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")

public class categoria {
	
	// ID DA TABELA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENT E PRIMARYKEY
	private long id;
	
	// ATRIBUTO 1
	@NotBlank
	@Size(min = 3, max = 50, message = "O setor deve conter, no mínimo, 3 caracteres e, no máximo, 50.")
	private String setor;
	
	// ATRIBUTO 2
	@NotNull
	private boolean controlado;

	//FK
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<produto> produto;
	
	// GETSET
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public boolean isControlado() {
		return controlado;
	}

	public void setControlado(boolean controlado) {
		this.controlado = controlado;
	}


	

}
