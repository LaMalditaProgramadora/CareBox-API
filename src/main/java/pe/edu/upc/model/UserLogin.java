package pe.edu.upc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usersLogin")
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

	@Id
	@Column(name = "idUserLogin")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUserLogin;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToOne(mappedBy = "userLogin")
	private Client client;

	@OneToOne(mappedBy = "userLogin")
	private Administrator administrator;
}
