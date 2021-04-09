package pe.edu.upc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@Column(name = "idCategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	List<Product> products;
}

