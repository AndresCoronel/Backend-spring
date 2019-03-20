package com.bolsadeideas.spingboot.backend.apirest.controllers;

import java.util.Date;
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

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Testimonio;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.TestimonioPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IProductorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.ItestimonioService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")

public class TestimonioRestController {

	@Autowired
	private ItestimonioService testimonioService;
	@Autowired
	private IProductorService productorService;
	@Autowired
	private IConsumidorService consumidorService;
	
	@GetMapping("/testimonios")
	public List<Testimonio> index(){
		return testimonioService.findAll();
	}
	
	@GetMapping("/testimonios/{id_testimonio}")
	public Testimonio show(@PathVariable Long id_testimonio) {
		return testimonioService.findByIdTestimonio(id_testimonio);
	}
	
	@PostMapping("/testimonios")
	@ResponseStatus(HttpStatus.CREATED)
	public Testimonio create(@RequestBody TestimonioPojo testimonioPojo) {
		
		Testimonio testimonio = new Testimonio();
		Productor productor = this.productorService.findByCedulaProductor(testimonioPojo.getProductor());
		Consumidor consumidor = this.consumidorService.findByCedulaConsumidor(testimonioPojo.getConsumidor());
		
		testimonio.setCreate_at(new Date());
		testimonio.setDescripcion_testimonio(testimonioPojo.getDescripcion_testimonio());
		testimonio.setProductor(productor);
		testimonio.setConsumidor(consumidor);
	
		
		return testimonioService.save(testimonio);
	}
	
	@PutMapping("/testimonios/{id_testimonio}")
	public Testimonio update(@RequestBody Testimonio testimonio, @PathVariable Long id_testimonio) {
		Testimonio testimonioActual = testimonioService.findByIdTestimonio(id_testimonio);
		
		testimonioActual.setDescripcion_testimonio(testimonio.getDescripcion_testimonio());
		testimonioActual.setProductor(testimonio.getProductor());
		testimonioActual.setConsumidor(testimonio.getConsumidor());
		
		return testimonioService.save(testimonioActual);
		
		
	}
	
	@DeleteMapping("/testimonios/{id_testimonio}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_testimonio) {
		testimonioService.delete(id_testimonio);
	}
	
	
}
