package com.producto.mservice.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.mservice.modelo.Producto;
import com.producto.mservice.servicio.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos(){
		List<Producto> productos = productoService.getAll();
		if(productos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(productos);
	}

	@GetMapping("/ver/{id}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Long id){
		Producto producto = productoService.getProductoById(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		Producto nuevoProducto = productoService.save(producto);
		return ResponseEntity.ok(nuevoProducto);
	}
	
}
