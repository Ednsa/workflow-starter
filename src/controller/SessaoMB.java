package controller;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;
import model.Client;

@Named
@SessionScoped
public class SessaoMB implements Serializable {

	private Client client;

	private static final long serialVersionUID = 1L;
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public boolean isLogado() {
		if(client == null) {
			return false;
		}
		else {
			return true;
		}		
	}
	
	

//	public void loginUsuario() {
//
//		if (usuario.equalsIgnoreCase("UsuarioTeste") && senha.equals("123456")) {
//			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário logado", "Usuário Logado"));
//
//		} else {
//			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
//					"Usuário ou senha errados!", "Usuário ou senha errados!"));
//
//		}
//
//	}

}
