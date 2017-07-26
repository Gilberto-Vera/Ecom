package br.edu.tads.fsa.ifg.BEAN;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.tads.fsa.ifg.MODEL.Carrinho;
import br.edu.tads.fsa.ifg.MODEL.Produto;


@ManagedBean
@SessionScoped
public class CarrinhoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Carrinho carrinho = new Carrinho();
	private Produto produto = null;
	private Produto produtoSelecionado = null;
	
	public void adicionarNoCarrinho(){
		carrinho.adiciona(produtoSelecionado);
	}
	public void removerDoCarrinho(){
		carrinho.remove(produtoSelecionado);
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}
