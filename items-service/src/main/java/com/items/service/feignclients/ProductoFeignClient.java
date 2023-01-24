package com.items.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.items.service.modelo.Producto;
//,url="http://localhost:8081"
@FeignClient(name = "producto-service")
@RequestMapping("/producto")
public interface ProductoFeignClient {
	@PostMapping
	public Producto save(@RequestBody Producto producto);
	
	/*@GetMapping
	public List<Producto> listarProductos();
	
	@GetMapping("/{id}")
	public List<Producto> obtenerProducto(@PathVariable("id") Long id);*/
}
