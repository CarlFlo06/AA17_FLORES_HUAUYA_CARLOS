package com.items.service.servicio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.items.service.feignclients.ProductoFeignClient;
//import com.items.service.feignclients.ProductoFeignClient;
import com.items.service.modelo.Item;
import com.items.service.modelo.Producto;
//import com.items.service.repositorio.ItemsRepository;

@Service("serviceFeign")
public class ItemsService {
	@Autowired
	private RestTemplate restTemplate;
	
	/*@Autowired
	private ItemsRepository itemsRepository;*/
	
	@Autowired
	private ProductoFeignClient productoFeignClient;

	public Producto saveProducto(Producto producto) {
		Producto nuevoProducto = productoFeignClient.save(producto);
		return nuevoProducto;
	}
	
	public List<Producto> getProductos(){
		List<Producto> productos = restTemplate.getForObject("http://producto-service/producto", List.class);
		return productos;
	}
	
	public Item findById(Long id, Integer cantidad) {
		Map<String,String>pathVariables=new HashMap<String,String>();
		pathVariables.put("id", id.toString());
		Producto producto=restTemplate.getForObject("http://producto-service/producto/ver/{id}", Producto.class,pathVariables);
		return new Item(producto,cantidad);
	}
	public List<Item> findAll() {
		List<Producto>productos=Arrays.asList(restTemplate.getForObject("http://producto-service/producto",Producto[].class));
		return productos.stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}
	/*public List<Producto> getProductos(Long itemId){
		List<Producto> productos = restTemplate.getForObject("http://producto-service/listar" + itemId, List.class);
		return productos;
	}*/
}
