package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.ProductoDTO;
import pe.edu.upc.dto.RespuestaDTO;
import pe.edu.upc.service.ProductoService;

@CrossOrigin
@RestController
@RequestMapping(path = "/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping(path = "/listarProductos", produces = "application/json")
	public ResponseEntity<?> listarProductos() {
		RespuestaDTO respuestaDTO = new RespuestaDTO();
		try {
			List<ProductoDTO> productosDTO = productoService.listarProductos();
			if (productosDTO.size() == 0) {
				respuestaDTO.setEstado(0);
				respuestaDTO.setMensaje("Sin resultados");
			} else {
				respuestaDTO.setEstado(1);
				respuestaDTO.setMensaje("Productos encontrados");
				respuestaDTO.setProductos(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setEstado(-1);
			respuestaDTO.setMensaje("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listarProductosPorIdCategoria", produces = "application/json")
	public ResponseEntity<?> listarProductosPorIdCategoria(@RequestParam int idCategoria) {
		RespuestaDTO respuestaDTO = new RespuestaDTO();
		try {
			List<ProductoDTO> productosDTO = productoService.listarProductosPorIdCategoria(idCategoria);
			if (productosDTO.size() == 0) {
				respuestaDTO.setEstado(0);
				respuestaDTO.setMensaje("Sin resultados");
			} else {
				respuestaDTO.setEstado(1);
				respuestaDTO.setMensaje("Productos encontrados");
				respuestaDTO.setProductos(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setEstado(-1);
			respuestaDTO.setMensaje("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listarProductosPorNombre", produces = "application/json")
	public ResponseEntity<?> listarProductosPorNombre(@RequestParam String nombre) {
		RespuestaDTO respuestaDTO = new RespuestaDTO();
		try {
			List<ProductoDTO> productosDTO = productoService.listarProductosPorNombre(nombre);
			if (productosDTO.size() == 0) {
				respuestaDTO.setEstado(0);
				respuestaDTO.setMensaje("Sin resultados");
			} else {
				respuestaDTO.setEstado(1);
				respuestaDTO.setMensaje("Productos encontrados");
				respuestaDTO.setProductos(productosDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setEstado(-1);
			respuestaDTO.setMensaje("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
