package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.Client;
import model.OrderService;
import model.Skill;
import model.Telephone;
import model.dao.ClientDAO;
import model.dao.OrderServiceDAO;
import model.dao.SkillDAO;

@ManagedBean(name = "orderServiceMB")
@RequestScoped
public class OrderServiceMB {

	// relations
	protected SkillDAO skillDAO = new SkillDAO();
	private ClientDAO clientDAO = new ClientDAO();
	private Client client = new Client();
	private List<Skill> skill = new ArrayList<>();
	private List<Skill> skillsSelected = new ArrayList<>();
	private OrderService orderService = new OrderService();
	private OrderServiceDAO orderServiceDAO = new OrderServiceDAO();

	// vars
	private Integer idClient;
	
	// acess methods


	// constructor
	public OrderServiceMB() {
		skill = skillDAO.listAll(); 
	}

	// gets and sets

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public SkillDAO getSkillDAO() {
		return skillDAO;
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public List<Skill> getSkillsSelected() {
		return skillsSelected;
	}

	public void setSkillsSelected(List<Skill> skillsSelected) {
		this.skillsSelected = skillsSelected;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderServiceDAO getOrderServiceDAO() {
		return orderServiceDAO;
	}

	public void setOrderServiceDAO(OrderServiceDAO orderServiceDAO) {
		this.orderServiceDAO = orderServiceDAO;
	}
	
	// lista todas ordens de servico

	// salva uma ordem de servico
	public String save() {
		
	

	
		orderService.setClient(clientDAO.loadById(idClient));
		// orderService.setClientFreelancer(clientFreelancer);
		orderService.setSkills(skillsSelected);
		orderServiceDAO.save(orderService);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo Com Sucesso!"));
		return "";

	}
	
	

}
