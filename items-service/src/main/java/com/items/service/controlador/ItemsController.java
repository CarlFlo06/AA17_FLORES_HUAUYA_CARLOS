package com.items.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.items.service.modelo.Item;
import com.items.service.modelo.Producto;
import com.items.service.servicio.ItemsService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/item")
public class ItemsController {
	@Autowired
	@Qualifier("serviceFeign")
	private ItemsService itemsService;
	
	@CircuitBreaker(name = "productosCB", fallbackMethod = "fallBackGetItem")
	@GetMapping
	public ResponseEntity<List<Item>>listarItem(){
		return ResponseEntity.ok(itemsService.findAll());
	}
	
	@CircuitBreaker(name = "productosCB", fallbackMethod = "fallBackGetProductos")
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProductos(){
		List<Producto> productos = itemsService.getProductos();
		return ResponseEntity.ok(productos);
	}
	
	@CircuitBreaker(name = "productosCB", fallbackMethod = "fallBackGetObtenerProductos")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public ResponseEntity<Item> detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return ResponseEntity.ok(itemsService.findById(id, cantidad));
	}
	
	@CircuitBreaker(name = "productosCB", fallbackMethod = "fallBackSaveProducto")
	@PostMapping("/guardar")
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		Producto nuevoProducto = itemsService.saveProducto(producto);
		return ResponseEntity.ok(nuevoProducto);
	}

	private ResponseEntity<List<Producto>> fallBackGetObtenerProductos(
			RuntimeException excepcion) {
		return new ResponseEntity("Opps! parece que ocurrio un problema, estamos trabajando para solucionarlo", HttpStatus.OK);
	}
	
	private ResponseEntity<List<Producto>> fallBackGetProductos(
			RuntimeException excepcion) {
		return new ResponseEntity("Opps! parece que ocurrio un problema, estamos trabajando para solucionarlo", HttpStatus.OK);
	}
	
	private ResponseEntity<List<Item>> fallBackSaveProducto(@RequestBody Producto producto,
			RuntimeException excepcion) {
		return new ResponseEntity("Opps! parece que ocurrio un problema, estamos trabajando para solucionarlo", HttpStatus.OK);
	}
	
	private ResponseEntity<List<Item>> fallBackGetItem(
			RuntimeException excepcion) {
		return new ResponseEntity("Opps! parece que ocurrio un problema, estamos trabajando para solucionarlo", HttpStatus.OK);
	}
	
}
