package model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.omnifaces.util.Messages;

import model.Client;

public class ClientDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	EntityManager em = JPAUtil.getEntityManager();

	public void save(Client client) {
			
		
		em.getTransaction().begin();

		em.merge(client);

		em.getTransaction().commit();

		em.close();

	}


	@SuppressWarnings("unchecked")
	public List<Client> listAll() {

		EntityManager entitymanager = JPAUtil.getEntityManager();

		Query query = entitymanager.createQuery("from Client");

		return query.getResultList();
	}

	public Client loadById(Integer id) {
		return em.find(Client.class, id);

	}

	public Client loadByCPF(String cpf) {
		try {
			String jpql = "from Client u where u.cpf= :cpf";

			TypedQuery<Client> consult = em.createQuery(jpql, Client.class);
			consult.setParameter("cpf", cpf);

			System.out.println(cpf);
			
			return (Client) consult.getSingleResult();
	
		} catch (Exception e) {

			Messages.addFlashGlobalInfo("Cpf nao encontrado ou senha invalida"); 
			return null;
		}
	}

}
