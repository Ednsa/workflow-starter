package model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Client;

@Named
public class ClientDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	EntityManager em = JPAUtil.getEntityManager();

	public void save(Client client) {
		//verificar se ja existe 
		
		
		em.getTransaction().begin();

		em.merge(client);

		em.getTransaction().commit();

		em.close();

	}

	// METODO NAO ESTA SENDO UTILIZADO POR ENQUANTO, FUTURAMENTE DEVERA SER
	// IMPLEMENTADO NA TELA DE UM ADMIN POR EXEMPLO
	@SuppressWarnings("unchecked")
	public List<Client> listAll() {
		// refatorar este trecho, verificar se ha a necessidade de instanciar novamente
		// entitymanager
		EntityManager entitymanager = JPAUtil.getEntityManager();

		Query query = entitymanager.createQuery("from Client");

		return query.getResultList();
	}

	// CARREGAR UM FREELANCER DO BANCO
	public Client loadById(Integer id) {
		return em.find(Client.class, id);

	}

	public Client lerPorCPF(String cpf) {
		try {
			String jpql = "from Client u where u.cpf= :cpf";

			TypedQuery<Client> consult = em.createQuery(jpql, Client.class);
			consult.setParameter("cpf", cpf);

			System.out.println(cpf);
			
			return (Client) consult.getSingleResult();
	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
