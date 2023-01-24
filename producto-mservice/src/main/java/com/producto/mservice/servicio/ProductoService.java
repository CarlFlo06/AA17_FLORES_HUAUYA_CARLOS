package com.producto.mservice.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.mservice.modelo.Producto;
import com.producto.mservice.repositorio.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>)productoRepository.findAll();
	}
	
	public Producto getProductoById(Long id){
		return productoRepository.findById(id).orElse(null);
	}
	
	public Producto save(Producto producto) {
		Producto nuevoProducto = productoRepository.save(producto);
		return nuevoProducto;
	}
	
	/*public List<Producto> byItemId(Long itemId){
		return productoRepository.findByItemId(itemId);
	}*/
}
