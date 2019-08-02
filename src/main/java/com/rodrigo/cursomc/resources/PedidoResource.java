package com.rodrigo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.cursomc.domain.Pedido;
import com.rodrigo.cursomc.services.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController 
@RequestMapping(value = "/pedidos")



public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
//	@GetMapping("/{id}")
	public ResponseEntity<?> find (@PathVariable Integer id) throws ObjectNotFoundException{	
			
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

/**	@PostMapping()
	
	@PutMapping
	
	@DeleteMapping
	
	**/
}
