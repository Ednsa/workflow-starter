package model.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Client;
import model.OrderService;

public class OrderServiceDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	EntityManager em = JPAUtil.getEntityManager();

	public void save(OrderService orderService) {

		em.getTransaction().begin();

		em.merge(orderService);

		em.getTransaction().commit();

	

	}


	@SuppressWarnings("unchecked")
	public List<OrderService> listAll() {
	
		EntityManager entitymanager = JPAUtil.getEntityManager();

		Query query = entitymanager.createQuery("from OrderService");

		return query.getResultList();
	}

	// CARREGAR UM PEDIDO DO BANCO
	public OrderService loadById(Integer id) {
		return em.find(OrderService.class, id);

	}
}
