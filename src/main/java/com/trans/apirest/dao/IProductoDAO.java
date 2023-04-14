package com.trans.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trans.apirest.entity.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Long>{

}
