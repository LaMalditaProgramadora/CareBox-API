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
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "correo")
	private String correo;

	@Column(name = "contrasena")
	private String contrasena;

	@OneToOne(mappedBy = "usuario")
	private Cliente cliente;

	@OneToOne(mappedBy = "usuario")
	private Administrador administrador;
}
