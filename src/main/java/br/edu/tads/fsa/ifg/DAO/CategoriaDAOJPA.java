package br.edu.tads.fsa.ifg.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.tads.fsa.ifg.MODEL.Categoria;

public class CategoriaDAOJPA {
	
	
	public static boolean cadastrarCategoria(Categoria categoria) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(categoria);
		tx.commit();
		manager.close();
		
		return true;
	}
	
	public static Categoria buscaCategoria (int id) {
		
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Categoria p = manager.find(Categoria.class, id);
		manager.close();
		return p;
		
	}
	
	public static List<Categoria> listaCategoria(){
		
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Query query = manager.createQuery("from Categoria");
		
		@SuppressWarnings("unchecked")
		List<Categoria> listaCategoria = query.getResultList();
		
		manager.close();
		
		return listaCategoria;
	}
	
	public static boolean alteraCategoria(Categoria categoria) {
		EntityManager maneger = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = maneger.getTransaction();
		tx.begin();
		Categoria c = maneger.find(Categoria.class, categoria.getId_categoria());
		c.setNome(categoria.getNome());
		tx.commit();
		maneger.close();
		
		return true;
	}
	
	public static boolean excluiCategoria (int id) {
		
		EntityManager maneger = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = maneger.getTransaction();
		tx.begin();
		
		Categoria c = maneger.find(Categoria.class, id);
		maneger.remove(c);
		tx.commit();
		maneger.close();
		
		return true;
	}

}
