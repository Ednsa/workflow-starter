package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Skill;

public class SkillDAO {

	EntityManager em = JPAUtil.getEntityManager();

	public void save(Skill skill) {

		em.merge(skill);

		em.getTransaction().commit();

		em.close();

	}

	// load all instance from database
	@SuppressWarnings("unchecked")
	public List<Skill> listAll() {

		Query query = em.createQuery("from Skill");

		return query.getResultList();
	}

	// load one instance from database
	public Skill loadById(Integer id) {

		return em.find(Skill.class, id);

	}

}