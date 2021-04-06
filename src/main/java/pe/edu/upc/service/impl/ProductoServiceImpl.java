package pe.edu.upc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.ProductoDTO;
import pe.edu.upc.model.Producto;
import pe.edu.upc.repository.ProductoRepository;
import pe.edu.upc.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository productRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductoDTO> listarProductos() {
		List<Producto> productos = productRepository.findAll();
		return productos.stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
				  .collect(Collectors.toList());
	}

	@Override
	public List<ProductoDTO> listarProductosPorIdCategoria(int idCategoria) {
		List<Producto> productos = productRepository.findByCategoriaIdCategoria(idCategoria);
		return productos.stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
				  .collect(Collectors.toList());
	}

	@Override
	public List<ProductoDTO> listarProductosPorNombre(String nombre) {
		List<Producto> productos = productRepository.findByNombreContainingIgnoreCase(nombre);
		return productos.stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
				  .collect(Collectors.toList());
	}

}
