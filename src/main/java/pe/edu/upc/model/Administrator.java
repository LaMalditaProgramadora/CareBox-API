package pe.edu.upc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "administrators")
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
	
	@Id
	@Column(name = "idAdministrator")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrator;
	
	@Column(name = "names")
	private String names;
	
	@Column(name = "lastNames")
	private String lastNames;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUserLogin", referencedColumnName = "idUserLogin")
	private UserLogin userLogin;
}
