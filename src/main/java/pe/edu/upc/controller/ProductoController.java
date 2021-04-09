package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.ProductDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/products")
public class ProductoController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/listAll", produces = "application/json")
	public ResponseEntity<?> listAll() {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<ProductDTO> productosDTO = productService.listAll();
			if (productosDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Productos encontrados");
				respuestaDTO.setProducts(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listByIdCategory", produces = "application/json")
	public ResponseEntity<?> listByIdCategory(@RequestParam int idCategory) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<ProductDTO> productosDTO = productService.listByIdCategory(idCategory);
			if (productosDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Productos encontrados");
				respuestaDTO.setProducts(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listByName", produces = "application/json")
	public ResponseEntity<?> listByName(@RequestParam String name) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<ProductDTO> productosDTO = productService.listByName(name);
			if (productosDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Productos encontrados");
				respuestaDTO.setProducts(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
	
	@GetMapping(path = "/listByIdCategoryAndName", produces = "application/json")
	public ResponseEntity<?> listByIdCategoryAndName(@RequestParam int idCategory, @RequestParam String name) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<ProductDTO> productosDTO = productService.listByCategoryIdCategoryAndNameContainingIgnoreCase(idCategory, name);
			if (productosDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Productos encontrados");
				respuestaDTO.setProducts(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
