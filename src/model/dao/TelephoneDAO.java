package model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Telephone;

public class TelephoneDAO implements Serializable {

	private static final long serialVersionUID = 12345L;
	
	EntityManager em = JPAUtil.getEntityManager();

	public void save(Telephone telephone) {

		em.getTransaction().begin();

		em.merge(telephone);

		em.getTransaction().commit();

		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Telephone> listAll() {
		Query query = em.createQuery("from Telephone");

		return query.getResultList();
	}

	// CARREGAR HABILIDADES DO BANCO
	public Telephone lerPorId(Integer id) {

		EntityManager em = JPAUtil.getEntityManager();
		return em.find(Telephone.class, id);

	}

}