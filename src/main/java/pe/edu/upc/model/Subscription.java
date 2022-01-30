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
@Table(name = "subscription")
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

	@Id
	@Column(name = "idSubscription")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubscription;

	@Column(name = "deliveryDate")
	private String deliveryDate;

	@Column(name = "deliveredThisMonth")
	private boolean deliveredThisMonth;

	@Column(name = "deliveries")
	private int deliveries;

	@Column(name = "address")
	private String address;

	@Column(name = "price")
	private double price;

	@ManyToOne
	@JoinColumn(name = "idBox", nullable = false)
	private Box box;

	@ManyToOne
	@JoinColumn(name = "idClient", nullable = false)
	private Client client;
}
