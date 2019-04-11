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

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IProductorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductorRestController {

	@Autowired
	private IProductorService productorService;

	@GetMapping("/productores")
	public List<Productor> index() {
		return productorService.findAll();
	}

	@GetMapping("/productores/{cedula_productor}")
	public Productor show(@PathVariable Long cedula_productor) {
		return productorService.findByCedulaProductor(cedula_productor);
	}

	@PostMapping("/productores")
	@ResponseStatus(HttpStatus.CREATED)
	public Productor create(@RequestBody Productor productor) {
		return productorService.save(productor);
	}

	@PutMapping("/productores/{cedula_productor}")
	@ResponseStatus(HttpStatus.CREATED)
	public Productor update(@RequestBody Productor productor, @PathVariable Long cedula_productor) {
		Productor productorActual = productorService.findByCedulaProductor(cedula_productor);

		productorActual.setNombre_productor(productor.getNombre_productor());
		productorActual.setApellido_productor(productor.getApellido_productor());
		productorActual.setSexo_productor(productor.getSexo_productor());
		productorActual.setTelefono_productor(productor.getTelefono_productor());
		productorActual.setCorreo_productor(productor.getCorreo_productor());
		productorActual.setContrasenia_productor(productor.getContrasenia_productor());
		productorActual.setUsuario_productor(productor.getUsuario_productor());

		return productorService.save(productorActual);

	}

	@DeleteMapping("/productores/{cedula_productor}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long cedula_productor) {
		productorService.delete(cedula_productor);
	}

}
