package com.exercicio01.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("Exercicio01");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
