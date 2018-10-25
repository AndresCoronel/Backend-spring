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

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IOfertaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class OfertaRestController {
	
	@Autowired
	private IOfertaService ofertaService;
	
	@GetMapping("/ofertas")
	public List<Oferta> index(){
		return ofertaService.findAll();
	}
	
	@GetMapping("/ofertas/{id_oferta}")
	public Oferta show(@PathVariable Long id_oferta) {
		return ofertaService.findByIdOferta(id_oferta);
	}
	
	@PostMapping("/ofertas")
	@ResponseStatus(HttpStatus.CREATED)
	public Oferta create(@RequestBody Oferta oferta) {
		return ofertaService.save(oferta);
	}
	
	@PutMapping("/ofertas/{id_oferta}")
	public Oferta update(@RequestBody Oferta oferta, @PathVariable Long id_oferta) {
		Oferta ofertaActual = ofertaService.findByIdOferta(id_oferta);
		
		ofertaActual.setNombre_producto(oferta.getNombre_producto());
		ofertaActual.setUnidad_medida_producto(oferta.getUnidad_medida_producto());
		ofertaActual.setCantidad_producto(oferta.getCantidad_producto());
		ofertaActual.setPrecio_producto(oferta.getPrecio_producto());
		ofertaActual.setVariedad_producto(oferta.getVariedad_producto());
		ofertaActual.setDescripcion_producto(oferta.getVariedad_producto());
		ofertaActual.setUbicacion_oferta(oferta.getUbicacion_oferta());
		ofertaActual.setLugar_oferta(oferta.getLugar_oferta());
		ofertaActual.setEstado_oferta(oferta.getEstado_oferta());
		ofertaActual.setFecha_recoleccion_oferta(oferta.getFecha_recoleccion_oferta());
		ofertaActual.setProductor(oferta.getProductor());
		
		return ofertaService.save(ofertaActual);
		
		
	}
	
	@DeleteMapping("/ofertas/{id_oferta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_oferta) {
		ofertaService.delete(id_oferta);
	}
	
	
	
}