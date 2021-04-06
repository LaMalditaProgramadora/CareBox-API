package pe.edu.upc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "suscripciones")
@AllArgsConstructor
@NoArgsConstructor
public class Suscripcion {

	@Id
	@Column(name = "idSuscripcion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSuscripcion;

	@Column(name = "fechaDeEntrega")
	private String fechaDeEntrega;

	@Column(name = "entergadoEsteMes")
	private boolean entergadoEsteMes;

	@Column(name = "entregasRealizadas")
	private int entregasRealizadas;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "precio")
	private float precio;

	@ManyToOne
	@JoinColumn(name = "idBox", nullable = false)
	private Box box;

	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;
}
