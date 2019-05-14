package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	// IMPLEMENTAR PARAS PROXIMAS AULAS UM 
	/* NOVO DAO UTILIZANDO GENERICS
	 * 
	 */
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
	
	
	public static EntityManager getEntityManager()
	{
		return factory.createEntityManager();
	}
	
}
