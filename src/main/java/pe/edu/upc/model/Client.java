package pe.edu.upc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Id
	@Column(name = "idClient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;

	@Column(name = "names")
	private String names;

	@Column(name = "lastNames")
	private String lastNames;

	@Column(name = "phone")
	private String phone;

	@Column(name = "adress")
	private String adress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUserLogin", referencedColumnName = "idUserLogin")
	private UserLogin userLogin;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Box> savedBoxes;
	
	@OneToMany(mappedBy = "client")
	List<Subscription> subscriptions;
}
