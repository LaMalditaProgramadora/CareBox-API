package pe.edu.upc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@Column(name = "idProduct")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;

	@Column(name = "name")
	private String name;

	@Column(name = "brand")
	private String brand;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "idCategory", nullable = false)
	private Category category;

	@ManyToMany
	@JoinTable(name = "productBox", joinColumns = @JoinColumn(name = "idProduct"), inverseJoinColumns = @JoinColumn(name = "idBox"))
	private List<Box> boxes;
}
