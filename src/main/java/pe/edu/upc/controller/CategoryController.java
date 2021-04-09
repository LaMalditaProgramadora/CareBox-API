package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.CategoryDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(path = "/listAll", produces = "application/json")
	public ResponseEntity<?> listAll() {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<CategoryDTO> categoriesDTO = categoryService.listAll();
			if(categoriesDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Categorías encontradas");
				respuestaDTO.setCategories(categoriesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
