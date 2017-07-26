package br.edu.tads.fsa.ifg.MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.tads.fsa.ifg.DAO.ProdutoDAOJPA;

/*import br.edu.ifg.formosa.tads.ECommerce.JSF.util.SessionContext;
import br.edu.ifg.formosa.tads.ECommerceJSF.DAO.ProdutoDAO;*/


public class Carrinho implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 16548154L;
	private HashMap<Integer, Integer> carrinho = new HashMap<Integer, Integer>();
	
	public void resetaCarrinho(){
		carrinho = new HashMap<Integer, Integer>();
	}

	 public void adiciona(Produto produto) {
		 
		 Integer quantidade = carrinho.get(produto.getId_produto());
		 if(quantidade!=null){
			 carrinho.put(produto.getId_produto(), quantidade+1);
		 }
		else{
		     carrinho.put(produto.getId_produto(), 1);
		}
	 }
	 
	 public void remove(Produto produto) {
		   carrinho.remove(produto.getId_produto());
	  }
	 
	 public Integer getTotalDeItens() {
		    return carrinho.size();
	 }
	 
	 public List<Produto> getProdutosCarrinho(){
		 

		 List<Produto> produtosCarrinho = new ArrayList<Produto>();
		carrinho.forEach((key, value) -> {
			 Produto p = ProdutoDAOJPA.buscaProduto(key);
			 p.setQuantidadeCarrinho(value);
			 produtosCarrinho.add(p);
		});
		 return produtosCarrinho;
	 }

	public void incrementarProdutoCarrinho(Produto produto) {
		Integer quantidade = carrinho.get(produto.getId_produto());
		carrinho.put(produto.getId_produto(), quantidade+1);
		
	}
	
	public void decrementarProdutoCarrinho(Produto produto) {
		Integer quantidade = carrinho.get(produto.getId_produto());
		if(quantidade>1)
			carrinho.put(produto.getId_produto(), quantidade-1);
		else{
			carrinho.remove(produto.getId_produto());
		}
		
	}
	
}
