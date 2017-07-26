package br.edu.tads.fsa.ifg.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionManagerJPA {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("ECommerceJSF");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	public static void close() {
		factory.close();
	}

}
