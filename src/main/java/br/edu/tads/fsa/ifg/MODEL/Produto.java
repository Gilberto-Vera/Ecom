package br.edu.tads.fsa.ifg.MODEL;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="produto")

public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11605388187350L;
	
	@Id
	@GeneratedValue
	private int id_produto;
	private String nome;
	private String descricao;
	private double valor;
	private int estoque;
	
	@ManyToOne
	@JoinColumn (name="id_secao")
	private Categoria categoria;
	
	@Transient
	private int quantidadeCarrinho = 0;

	public int getQuantidadeCarrinho() {
		return quantidadeCarrinho;
	}
	public void setQuantidadeCarrinho(int quantidadeCarrinho) {
		this.quantidadeCarrinho = quantidadeCarrinho;
	}
	public String getNome() {
		return nome;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}

