package pe.edu.upc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.CategoryDTO;
import pe.edu.upc.model.Category;
import pe.edu.upc.repository.CategoryRepository;
import pe.edu.upc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<CategoryDTO> listAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
				.collect(Collectors.toList());
	}

}
