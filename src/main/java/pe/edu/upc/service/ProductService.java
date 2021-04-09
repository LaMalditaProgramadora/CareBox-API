package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> listAll();
	List<ProductDTO> listByIdCategory(int idCategory);
	List<ProductDTO> listByName(String name);
	List<ProductDTO> listByCategoryIdCategoryAndNameContainingIgnoreCase(int idCategory, String name);
}
