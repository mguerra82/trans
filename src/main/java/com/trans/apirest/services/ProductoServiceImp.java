package com.trans.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trans.apirest.dao.IProductoDAO;
import com.trans.apirest.entity.Producto;

@Service
public class ProductoServiceImp implements IProductoServices {

	@Autowired(required = true)
	private IProductoDAO productoDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoDAO.save(producto);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		productoDAO.deleteById(id);
	}

}
