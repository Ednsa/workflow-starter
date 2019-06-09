package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletResponse;

import org.jasypt.util.text.BasicTextEncryptor;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;

import filters.ControleAcessoFilter;
import model.Client;
import model.Skill;
import model.Telephone;
import model.dao.ClientDAO;
import model.dao.SkillDAO;

@ManagedBean
@ViewScoped
public class ClientMB implements Serializable {

	private static final long serialVersionUID = 1L;

	// vars
	private Client client = new Client();;
	@Inject
	private ClientDAO clientDAO = new ClientDAO();
	private List<Skill> skill = new ArrayList<>();
	private List<Skill> skillsSelected = null;
	protected SkillDAO skillDAO = new SkillDAO();
	private Telephone telephone = new Telephone();
	private Telephone cellphone = new Telephone();
	private List<Telephone> telephones = new ArrayList<Telephone>();
	ControleAcessoFilter controlFilter = new ControleAcessoFilter();

	
	// constructor
	public ClientMB() {
		skill = skillDAO.listAll();

	}

	// gets and sets

	public List<Skill> getSkillsSelected() {
		return skillsSelected;
	}

	// LISTA TODOS OS FREELANCERS CADASTRADOS
	public void listAll() {
	}
	
	
	// save one client
	public String save() {

		telephones.add(telephone);
		telephones.add(cellphone);
		client.setTelephones(telephones);
		client.setSkills(skillsSelected);
		clientDAO.save(client);
		Messages.addFlashGlobalInfo("Usuario salvo com sucesso!");
		return "/../index?faces-redirect=true";
	}

	// CARREGAR DO BANCO ATRAV�S DO ID
	public void acaoEditar() {
		this.client = this.clientDAO.loadById(client.getId());

	}

	public void upload(FileUploadEvent event) {
		System.out.println("Chamou o metodo");
	}
	
	public String goToIndex() {
		System.out.println("entrou no goIndex");
		return "index?faces-redirect=true";
	}

	public String goToRegister(){
	return "/notAuthenticated/cadastroPedido?faces-redirect=true";
	}

	public String goToRegisterOrder() {
		return "/authenticated/cadastroPedido?faces-redirect=true";
	}

//	
//	
//	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) {
//		String email = (String) value;
//
//		if (email.indexOf('@') == -1) {
//			((UIInput) toValidate).setValid(false);
//
//			FacesMessage message = new FacesMessage("Email inv�lido");
//			context.addMessage(toValidate.getClientId(context), message);
//		}
//	}

	/// gets and sets

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	public List<Skill> getskillsSelected() {
		return skillsSelected;
	}

	public void setSkillsSelected(List<Skill> skillsSelected) {
		this.skillsSelected = skillsSelected;
	}

	public SkillDAO getSkillDAO() {
		return skillDAO;
	}

	public void setSkillDAO(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Telephone getCellphone() {
		return cellphone;
	}

	public void setCellphone(Telephone cellphone) {
		this.cellphone = cellphone;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

//     LIST QUE RECEBE UM getLabel DAS ENUM's CRIADAS FALTA GET E SET
//	 private List<TipoHabilidade> tipos = Arrays.asList(TipoHabilidade.values()); 
//	

}