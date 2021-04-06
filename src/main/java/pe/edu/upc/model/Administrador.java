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
@Table(name = "administradores")
@AllArgsConstructor
@NoArgsConstructor
public class Administrador {
	
	@Id
	@Column(name = "idAdministrador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "telefono")
	private String telefono;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario usuario;
}
