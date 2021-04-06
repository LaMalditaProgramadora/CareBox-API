package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
	private int idProducto;
	private String nombre;
	private String marca;
	private float precio;
	private String descripcion;
	private CategoriaDTO categoria;
}
