package com.bolsadeideas.spingboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IConsumidorDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ConsumidorRestController {
	
	@Autowired
	private IConsumidorService consumidorService;
	@Autowired
	private IConsumidorDao consumidorDao;
	
	@GetMapping("/consumidores")
	public List<Consumidor> index(){
		return consumidorService.findAll();
	}
	@GetMapping("/consumidores/{cedula_consumidor}")
	public Consumidor show(@PathVariable Long cedula_consumidor) {
		return consumidorService.findByCedulaConsumidor(cedula_consumidor);
	}
	@PostMapping("/consumidores")
	@ResponseStatus(HttpStatus.CREATED)
	public Consumidor create(@RequestBody Consumidor consumidor) {
		return consumidorService.save(consumidor);
	}
	
	@PutMapping("/consumidores/{cedula_consumidor}")
	@ResponseStatus(HttpStatus.CREATED)
	public Consumidor update(@RequestBody Consumidor consumidor, @PathVariable Long cedula_consumidor) {
		Consumidor consumidorActual= consumidorService.findByCedulaConsumidor(cedula_consumidor);
		
		consumidorActual.setNombre_consumidor(consumidor.getNombre_consumidor());
		consumidorActual.setApellido_consumidor(consumidor.getApellido_consumidor());
		consumidorActual.setSexo_consumidor(consumidor.getSexo_consumidor());
		consumidorActual.setTelefono_consumidor(consumidor.getTelefono_consumidor());
		consumidorActual.setCorreo_consumidor(consumidor.getCorreo_consumidor());
		consumidorActual.setContrasenia_consumidor(consumidor.getContrasenia_consumidor());
		
		return consumidorService.save(consumidorActual);
		
	}
	
	@DeleteMapping("/consumidores/{cedula_consumidor}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long cedula_consumidor) {
		consumidorService.delete(cedula_consumidor);
	}
	
	@GetMapping("/consumidores/{username}")
	public Consumidor getUsuario(@PathVariable String username) {
		System.out.println("perro");
		return consumidorDao.findByUsername(username);
	}
	
	

}
