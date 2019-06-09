package controller;

import java.io.IOException;
import java.io.Serializable;

import org.jasypt.util.text.BasicTextEncryptor;
import org.omnifaces.util.Messages;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.ClientDAO;
import model.Client;

@Named
@ViewScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SessaoMB sessao;
	
	@Inject
	private ClientDAO dao;

	private Client client;
	private String cpf;
	private String senha;
	
	public SessaoMB getSessao() {
		return sessao;
	}

	public void setSessao(SessaoMB sessao) {
		this.sessao = sessao;
	}



	public String actionAuth() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();	
		client = dao.loadByCPF(cpf);
		if (this.client != null) {//a
			if (!client.getPassword().equals(Encrypt.encriptografar(senha))) {
				//ok
				client = null;
				//Usuario nao encontrado ou senha inv�lida 
				FacesContext.getCurrentInstance().addMessage("formLogin", new FacesMessage("Cpf nao encontrado ou senha invalida"));
			} else {
				//usuario encontrado e senha ok
				sessao.setClient(client);	
				Messages.addFlashGlobalInfo("Login realizado com sucesso!");
				 ec.redirect(ec.getRequestContextPath() + "/index.jsf");
				 return "";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("formLogin", new FacesMessage("Cpf nao encontrado ou senha invalida"));
		}
		return "abc.jsf";

//		 else {
//			FacesContext contexto = FacesContext.getCurrentInstance();
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio ou Senha Incorreta", null);
//			FacesContext.getCurrentInstance().addMessage("usuario", msg);
//
//			return "";
//		}
	}

	
	/**
	 * @throws ServletException 
	 * @throws IOException 
	 * 
	 */
//	public String actionLogout() throws ServletException, IOException {
//
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		 
//		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
//		 
//		// Log Out of the Session
//		request.logout();
//		 
//		ec.invalidateSession();
//		ec.getSessionMap().clear();
//		 
//		//ec.redirect(ec.getRequestContextPath() + "/index.jsf");
//		return "boots.jsf";
//
//	}

	public String logout(){
	    System.out.println("Entrou no logout ");
		
		try{
	        FacesContext facesContext = FacesContext.getCurrentInstance();  
	        ExternalContext ex = facesContext.getExternalContext();  
	        ex.invalidateSession();
	        return "/notAuthenticated/login.jsf?faces-redirect=true"; 
	    }catch(Exception e){
	        return "error";
	    }
	}
	
	
	
	public ClientDAO getDao() {
		return dao;
	}

	public void setDao(ClientDAO dao) {
		this.dao = dao;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
