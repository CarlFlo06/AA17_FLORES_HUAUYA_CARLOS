package com.producto.mservice.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producto.mservice.modelo.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	//List<Producto> findByItemId(Long itemId);
	public List<Producto>findAll();
}
