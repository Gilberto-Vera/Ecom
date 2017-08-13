package br.edu.tads.fsa.ifg.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.edu.tads.fsa.ifg.MODEL.Usuario;

public class UsuarioDAOJPA {
	
	public static boolean cadastrarUsuario(Usuario usuario) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(usuario);
		tx.commit();
		manager.close();
		return true;
	}

	public static Usuario buscaUsuario(int id) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Usuario u = manager.find(Usuario.class, id);
		manager.close();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public static Usuario buscaUsuarioLogin(String login) {

		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login ='" + login + "'");
		List<Usuario> usuarios = query.getResultList();
		manager.close();
		if(usuarios.isEmpty()){
			System.out.println("não achou");
			return null;
		}
		else{
			System.out.println(usuarios.get(0).getNome());
			return usuarios.get(0);
		}
	}
	
	public static boolean alterarUsuario(Usuario usuario) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Usuario u = manager.find(Usuario.class, usuario.getId());
		u.setNome(usuario.getNome());
		u.setLogin(usuario.getLogin());
		u.setTipo(usuario.getTipo());
		u.setSenha(usuario.getSenha());
		tx.commit();
		manager.close();
		return true;
	}

	public static boolean excluirUsuario(int id) {
		EntityManager manager = ConnectionManagerJPA.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Usuario u = manager.find(Usuario.class, id);
		manager.remove(u);
		tx.commit();
		manager.close();
		return true;
	}
}