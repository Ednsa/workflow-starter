package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderService implements Serializable {
	private static final long serialVersionUID = 12345L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;

	private String descriptionOfService;
	private String valueInitial;;
	private String valueFinal;	
	@Temporal(TemporalType.DATE)
	private Date initialDate;
	@Temporal(TemporalType.DATE)
	private Date finalDate;

	// relations

	@ManyToMany
	private List<Skill> skills = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY) // 
	@Basic(fetch = FetchType.LAZY)
	private Client client; //cliente que solicita o servico

	@ManyToOne
	@Basic(fetch = FetchType.LAZY)
	private Client clientFreelancer; //cliente que realiza o servico
	
	@ManyToMany
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "freelancer_fk")
	private List<Client> freelancersCandidates = new ArrayList<>(); // clientes concorrentes a execucao do serviço

	// constructors
	public OrderService(Long id, Client client, String descriptionOfService, String valueInitial, String valueFinal,
			Date initialDate, Date finalDate) {
		super();
		Id = id;
		this.client = client;
		this.descriptionOfService = descriptionOfService;
		this.valueInitial = valueInitial;
		this.valueFinal = valueFinal;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}

	public OrderService() {
		super();
	}

	// gets and sets

	public Long getId() {
		return Id;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getDescriptionOfService() {
		return descriptionOfService;
	}

	public void setDescriptionOfService(String descriptionOfService) {
		this.descriptionOfService = descriptionOfService;
	}

	public String getValueInitial() {
		return valueInitial;
	}

	public void setValueInitial(String valueInitial) {
		this.valueInitial = valueInitial;
	}

	public String getValueFinal() {
		return valueFinal;
	}

	public void setValueFinal(String valueFinal) {
		this.valueFinal = valueFinal;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Client getClientFreelancer() {
		return clientFreelancer;
	}

	public void setClientFreelancer(Client clientFreelancer) {
		this.clientFreelancer = clientFreelancer;
	}

	public List<Client> getFreelancersCandidates() {
		return freelancersCandidates;
	}

	public void setFreelancersCandidates(List<Client> freelancersCandidates) {
		this.freelancersCandidates = freelancersCandidates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	// hash and equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderService other = (OrderService) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "OrderService [Id=" + Id + ", client=" + client + ", freelancersCandidates=" + ", descriptionOfService="
				+ descriptionOfService + ", valueInitial=" + valueInitial + ", valueFinal=" + valueFinal + ", skills="
				+ skills + ", initialDate=" + initialDate + ", finalDate=" + finalDate + "]";
	}

}
