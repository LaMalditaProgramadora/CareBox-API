package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private int idProduct;
	private String name;
	private String url;
	private String brand;
	private double price;
	private String description;
	private CategoryDTO category;
}
