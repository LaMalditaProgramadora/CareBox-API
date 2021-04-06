package pe.edu.upc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "boxes")
@AllArgsConstructor
@NoArgsConstructor
public class Box {
	
	@Id
	@Column(name = "idBox")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBox;
	
	@Column(name = "precio")
	private float precio;
	
	@Column(name = "esPersonalizado")
	private boolean esPersonalizado;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "boxes")
	List<Producto> productos;
	
	@ManyToMany(mappedBy = "boxesGuardados")
	List<Cliente> clientes;
	
	@OneToMany(mappedBy = "box")
	List<Suscripcion> suscripciones;
	
}
