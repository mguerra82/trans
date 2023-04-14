package com.trans.apirest.services;

import java.util.List;

import com.trans.apirest.entity.Producto;

public interface IProductoServices {
	
	public List<Producto> findAll();

	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete (Long id);
}
