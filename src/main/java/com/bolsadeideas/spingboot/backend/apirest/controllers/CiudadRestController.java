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

import com.bolsadeideas.spingboot.backend.apirest.models.dao.ICiudadDao;
import com.bolsadeideas.spingboot.backend.apirest.models.dao.IConsumidorDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.services.ICiudadService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CiudadRestController {
	
	
	@Autowired
	private ICiudadService ciudadService;
	@Autowired
	private ICiudadDao ciudadDao;
	
	@GetMapping("/ciudades")
	public List<Ciudad> index() {
		System.out.println("entro a consultar");
		return ciudadService.findAll();
	}
	@GetMapping("/ciudades/{id_ciudad}")
	public Ciudad show(@PathVariable int id_ciudad) {
		return ciudadService.findByIdCiudad(id_ciudad);
	}
	
	
}
