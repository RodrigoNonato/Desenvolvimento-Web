package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil
{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("up_dw");

	public static EntityManager getEntityManager()
	{
		return emf.createEntityManager();
	}
}