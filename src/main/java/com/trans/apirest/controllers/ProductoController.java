package com.trans.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trans.apirest.entity.Producto;
import com.trans.apirest.services.IProductoServices;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	private IProductoServices productoServices;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		return productoServices.findAll();
	}

	@PostMapping("productos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Producto producto, BindingResult result){
		Producto prodNew = null;
		
		Map<String, Object> response = new HashMap<>();	
		
		try {
			
			prodNew = productoServices.save(producto);
			
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al insertar en la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "El producto ha sido creado con éxito");
		response.put("producto", prodNew);
				
		return new ResponseEntity<Producto>(prodNew, HttpStatus.CREATED);
	}
	
	@PostMapping("productosIn")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> cre(@RequestBody Producto producto, BindingResult result){
		return null;
	}
}
