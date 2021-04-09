package pe.edu.upc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.ProductDTO;
import pe.edu.upc.model.Product;
import pe.edu.upc.repository.ProductRepository;
import pe.edu.upc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductDTO> listAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> listByIdCategory(int idCategory) {
		List<Product> products = productRepository.findByCategoryIdCategory(idCategory);
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> listByName(String name) {
		List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ProductDTO> listByCategoryIdCategoryAndNameContainingIgnoreCase(int idCategory, String name) {
		List<Product> products = productRepository.findByCategoryIdCategoryAndNameContainingIgnoreCase(idCategory, name);
		return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
				.collect(Collectors.toList());
	}

}
