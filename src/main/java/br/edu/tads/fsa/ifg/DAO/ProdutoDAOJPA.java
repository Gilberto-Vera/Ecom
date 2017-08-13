package br.edu.tads.fsa.ifg.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.tads.fsa.ifg.MODEL.*;

public class ProdutoDAOJPA {
	public static boolean cadastrarProduto(Produto produto) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(produto);
		tx.commit();
		manager.close();
		return true;
	}

	public static Produto buscaProduto(int id) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Produto p = manager.find(Produto.class, id);
		manager.close();
		return p;
	}

	public static List<Produto> listaProdutos() {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Query query = manager.createQuery("from Produto");

		@SuppressWarnings("unchecked")
		List<Produto> listaProdutos = query.getResultList();
		manager.close();
		return listaProdutos;
	}

	public static boolean alterarProduto(Produto produto) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Produto p = manager.find(Produto.class, produto.getId_produto());
		p.setNome(produto.getNome());
		p.setDescricao(produto.getDescricao());
		p.setValor(produto.getValor());
		p.setEstoque(produto.getEstoque());	
		tx.commit();
		manager.close();
		return true;
	}

	public static boolean excluirProduto(int id) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Produto p = manager.find(Produto.class, id);
		manager.remove(p);
		tx.commit();
		manager.close();
		return true;
	}
}
