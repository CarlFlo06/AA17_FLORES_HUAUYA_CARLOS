package com.items.service.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	private int cantidad;
	private Producto producto;
	
	public Item() {
		super();
	}
	
	public Item(Producto p, int cantidad) {
		super();
		this.producto = p;
		this.cantidad = cantidad;
	}
}
