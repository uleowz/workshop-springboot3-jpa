package com.devsuperior.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.course.entities.Order;
import com.devsuperior.course.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService userService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}") // Para falar que a URL tera um parametro.
	public ResponseEntity<Order> findById(@PathVariable Long id){ //para dizer que o parametro do método virá do parametro da url
		Order obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
