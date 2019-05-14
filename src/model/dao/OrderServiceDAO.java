package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Client;
import model.OrderService;

public class OrderServiceDAO {

	EntityManager em = JPAUtil.getEntityManager();

	public void save(OrderService orderService) {

		em.getTransaction().begin();

		em.merge(orderService);

		em.getTransaction().commit();

		em.close();

	}

	// METODO NAO ESTA SENDO UTILIZADO POR ENQUANTO, FUTURAMENTE DEVERA SER
	// IMPLEMENTADO NA TELA DE UM ADMIN POR EXEMPLO
	@SuppressWarnings("unchecked")
	public List<OrderService> listAll() {
		// refatorar este trecho, verificar se ha a necessidade de instanciar novamente
		// entitymanager
		EntityManager entitymanager = JPAUtil.getEntityManager();

		Query query = entitymanager.createQuery("from OrderService");

		return query.getResultList();
	}

	// CARREGAR UM FREELANCER DO BANCO
	public OrderService loadById(Integer id) {
		return em.find(OrderService.class, id);

	}
}
