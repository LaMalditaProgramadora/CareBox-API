package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.CategoriaDTO;
import pe.edu.upc.dto.RespuestaDTO;
import pe.edu.upc.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(path = "/listarCategorias", produces = "application/json")
	public ResponseEntity<?> listarCategorias() {
		RespuestaDTO respuestaDTO = new RespuestaDTO();
		try {
			List<CategoriaDTO> categoriasDTO = categoriaService.listarCategorias();
			if(categoriasDTO.size() == 0) {
				respuestaDTO.setEstado(0);
				respuestaDTO.setMensaje("Sin resultados");
			} else {
				respuestaDTO.setEstado(1);
				respuestaDTO.setMensaje("Categorías encontradas");
				respuestaDTO.setCategorias(categoriasDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setEstado(-1);
			respuestaDTO.setMensaje("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
