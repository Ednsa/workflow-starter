package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.jasypt.util.text.BasicTextEncryptor;

import controller.Encrypt;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 12345L;

	// attr

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String password;
	private String name;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Column(unique = true)
	private String cpf;
	private String email;

	@ManyToMany
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_skill_fk")
	private List<Skill> skills;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Telephone> telephones;

	@ManyToMany
	@Basic(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderService_fk")
	private List<OrderService> orderServices;
	// private BasicTextEncryptor cryptor = new BasicTextEncryptor();

	// constructors

	public Client(Integer id, String login, String password, String name, String lastName, Date birthDate, String cpf,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.email = email;

	}

	public Client() {

	}

	// gets and sets

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Encrypt.encriptografar(password);
	}

//
//	public void setCpfFormatted(String cpfNotFormatted) {
//
//		cpfNotFormatted.replaceAll(".", "").replaceAll("-", ""); 
//		cpf =	cpfNotFormatted; 
//		System.out.println(cpf); 
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	public List<OrderService> getOrderServices() {
		return orderServices;
	}

	public void setOrderServices(List<OrderService> orderServices) {
		this.orderServices = orderServices;
	}

	// hash and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	// toString

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthDate=" + birthDate + ", cpf="
				+ cpf + ", email=" + email + ", skills=" + skills + ", telephones=" + telephones + "]";
	}

}