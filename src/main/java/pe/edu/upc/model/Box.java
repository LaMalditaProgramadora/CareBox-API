package pe.edu.upc.model;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "personalized")
	private boolean personalized;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Product> products;
	
	@ManyToMany(mappedBy = "savedBoxes")
	List<Client> clients;
	
	@OneToMany(mappedBy = "box")
	List<Subscription> subscription;
	
}
