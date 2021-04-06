package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.dto.ProductoDTO;

public interface ProductoService {
	List<ProductoDTO> listarProductos();
	List<ProductoDTO> listarProductosPorIdCategoria(int idCategoria);
	List<ProductoDTO> listarProductosPorNombre(String nombre);
}
