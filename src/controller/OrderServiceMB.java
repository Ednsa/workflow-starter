package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import model.Client;
import model.OrderService;
import model.Skill;
import model.dao.ClientDAO;
import model.dao.OrderServiceDAO;
import model.dao.SkillDAO;

@Named
@ViewScoped
public class OrderServiceMB implements Serializable {

	private static final long serialVersionUID = 1L;
	protected SkillDAO skillDAO = new SkillDAO();
	private ClientDAO clientDAO = new ClientDAO();
	private List<Skill> skill = new ArrayList<>();
	private List<Skill> skillsSelected = new ArrayList<>();
	private List<OrderService> orders = new ArrayList<>();
	private OrderService orderService = new OrderService();
	private OrderServiceDAO orderServiceDAO = new OrderServiceDAO();
	private Client client = new Client();

	@Inject
	private SessaoMB sessaoMB;

	@PostConstruct
	public void init() {
		orders = orderServiceDAO.listAll();
	}

	public String save() {
		client = sessaoMB.getClient();
		orderService.setClient(client);
		// orderService.setClientFreelancer(clientFreelancer);
		orderService.setSkills(skillsSelected);
		orderServiceDAO.save(orderService);
		Messages.addFlashGlobalInfo("Pedido salvo com sucesso!");
		return "cadastroPedido?faces-redirect=true";
	}


	public String saveFreelancer() {
		System.out.println("entrouu");
//		client = sessaoMB.getClient();
//		orderService.setClientFreelancer(client);
//		client.setOrderServices(Arrays.asList(orderService));
//		clientDAO.save(client);
//		orderServiceDAO.save(orderService);
//		System.out.println("PAssou Aki");
//		System.out.println(orderService);
//		System.out.println(client);
//	
		return "";
	}
	
	

	// gets and sets
	public void setSkillDAO(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
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

	public List<OrderService> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderService> orders) {
		this.orders = orders;
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

	public SessaoMB getSessaoMB() {
		return sessaoMB;
	}

	public void setSessaoMB(SessaoMB sessaoMB) {
		this.sessaoMB = sessaoMB;
	}

}