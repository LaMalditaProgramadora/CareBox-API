package pe.edu.upc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.CategoriaDTO;
import pe.edu.upc.model.Categoria;
import pe.edu.upc.repository.CategoriaRepository;
import pe.edu.upc.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<CategoriaDTO> listarCategorias() {
		List<Categoria> categorias =  categoriaRepository.findAll();
		return categorias.stream()
				  .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
				  .collect(Collectors.toList());
	}
	
}
