package br.edu.tads.fsa.ifg.BEAN;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.tads.fsa.ifg.DAO.*;
import br.edu.tads.fsa.ifg.MODEL.*;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1681830300543445969L;
	private Produto produto = new Produto();
	private Carrinho carrinho = new Carrinho();
	private List<Produto> produtos = null;
	private Produto produtoSelecionado;
	
	public void novoCadastroProduto(){
		produto = new Produto();
	}
	
	public void resetaProduto(){
		produto = new Produto();
		produtoSelecionado = new Produto();
	}
	
	public void adicionarNoCarrinho(){
		carrinho.adiciona(produtoSelecionado);
		//resetaProduto();
	}
	public void removerDoCarrinho(){
		carrinho.remove(produtoSelecionado);
		//resetaProduto();
	}
	
	public void incrementarProdutoCarrinho(){
		carrinho.incrementarProdutoCarrinho(produtoSelecionado);
	}
	
	public void decrementarProdutoCarrinho(){
		carrinho.decrementarProdutoCarrinho(produtoSelecionado);
	}
	
	public void cadastraProduto(){
		 ProdutoDAOJPA.cadastrarProduto(produto);
		 FacesMessage mensagem = new FacesMessage("Produto Cadastrado") ;
		 FacesContext.getCurrentInstance().addMessage(null, mensagem) ;
		 novoCadastroProduto();	 
	}
	
	public void alteraProduto(){
		ProdutoDAOJPA.alterarProduto(produtoSelecionado);
		FacesMessage mensagem = new FacesMessage("Produto alterado com sucesso") ;
		FacesContext.getCurrentInstance().addMessage(null, mensagem) ;
		novoCadastroProduto();
	}
	
	public void removerProduto(){
		ProdutoDAOJPA.excluirProduto(produtoSelecionado.getId_produto());
		//FacesMessage mensagem = new FacesMessage("Produto removido com sucesso") ;
		//FacesContext.getCurrentInstance().addMessage(null, mensagem) ;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		produtos = ProdutoDAOJPA.listaProdutos();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutosCarrinho() {
		return carrinho.getProdutosCarrinho();
	}
	
	public void setProdutosCarrinho(List<Produto> produtosCarrinho) {
	}

}
