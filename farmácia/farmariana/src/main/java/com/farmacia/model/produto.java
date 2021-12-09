package com.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")

public class produto {

	//ID DA TABELA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENT E PRIMARYKEY
	private long id;
	
	//ATRIBUTO 1
	private String nomeProduto;
	
	//ATRIBUTO 2
	private double preco;
	
	//FK
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private categoria categoria;

	
	//GETSET
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
