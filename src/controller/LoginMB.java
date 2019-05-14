package controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
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



	public String acaoAutenticar() {
		client = dao.lerPorCPF(cpf);
		if (this.client != null) {//achou cliente mas a senha está inválida
			if (!client.getPassword().equals(senha)) {
				//ok
				client = null;
				System.out.println("Usuario não encontrado, ou senha inválida");
			} else {
				sessao.setClient(client);
				
				System.out.println("Autenticado...");
				return "index?faces-redirect=true?";

			}
		} else {
			System.out.println("...");
		}
		return "/paginas/cidadao/abc.jsf";

//		 else {
//			FacesContext contexto = FacesContext.getCurrentInstance();
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Incorreta", null);
//			FacesContext.getCurrentInstance().addMessage("usuario", msg);
//
//			return "";
//		}
	}

	public String home() {
		return "/paginas/cidadao/home.jsf?faces-redirect=true";
	}

	/**
	 * 
	 */
	public String acaoLogout() {

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

		// encerrar a sessão atual
		session.invalidate();

		return "/paginas/naoAutenticado/index.jsf?faces-redirect=true";
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
