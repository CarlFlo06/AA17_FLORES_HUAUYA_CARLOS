package com.items.service.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
	private Long id;
	private String nombre;
	private double precio;
	// private Long itemId;

	public Producto() {
		super();
	}

}
