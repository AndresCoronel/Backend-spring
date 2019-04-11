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
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.DemandaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IDemandaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DemandaRestController {
	
	@Autowired
	private IDemandaService demandaService;
	@Autowired
	private IConsumidorService consumidorService;
	
	@GetMapping("/demandas")
	public List<Demanda> index(){
		return demandaService.findAll();
	}
	@GetMapping("/demandas/{id_demanda}")
	public Demanda show(@PathVariable Long id_demanda) {
		return demandaService.findByIdDemanda(id_demanda);
	}
	@PostMapping("/demandas")
	@ResponseStatus(HttpStatus.CREATED)
	public Demanda create(@RequestBody DemandaPojo demandaPojo) {
	Demanda demanda = new Demanda();
	System.out.println(demandaPojo.getCiudad_demanda());
	
	Consumidor consumidor = this.consumidorService.findByCedulaConsumidor(demandaPojo.getConsumidor());
	System.out.println(consumidor.getNombre_consumidor());
	
		demanda.setCreate_at(new Date());
		demanda.setNombre_producto(demandaPojo.getNombre_producto());
		demanda.setCantidad_producto(demandaPojo.getCantidad_producto());
		demanda.setMedida_producto(demandaPojo.getMedida_producto());
		demanda.setDepartamento_demanda(demandaPojo.getDepartamento_demanda());
		demanda.setCiudad_demanda(demandaPojo.getCiudad_demanda());
		demanda.setDescripcion_demanda(demandaPojo.getDescripcion_demanda());
		demanda.setEstado_demanda(demandaPojo.getEstado_demanda());
		demanda.setVariedad_producto(demandaPojo.getVariedad_producto());
		demanda.setDireccion_demanda(demandaPojo.getDireccion_demanda());
		demanda.setConsumidor(consumidor);
		
		
		
		return demandaService.save(demanda);
		
	}
	
	@PutMapping("/demandas/{id_demanda}")
	@ResponseStatus(HttpStatus.CREATED)
	public Demanda update(@RequestBody Demanda demanda, @PathVariable Long id_demanda) {
		Demanda demandaActual= demandaService.findByIdDemanda(id_demanda);
		
		demandaActual.setNombre_producto(demanda.getNombre_producto());
		demandaActual.setCantidad_producto(demanda.getCantidad_producto());
		demandaActual.setMedida_producto(demanda.getMedida_producto());
		demandaActual.setDepartamento_demanda(demanda.getDepartamento_demanda());
		demandaActual.setCiudad_demanda(demanda.getCiudad_demanda());
		demandaActual.setDescripcion_demanda(demanda.getDescripcion_demanda());

		demandaActual.setEstado_demanda(demanda.getEstado_demanda());
		demandaActual.setVariedad_producto(demanda.getVariedad_producto());
		demandaActual.setDireccion_demanda(demanda.getDireccion_demanda());
		
		demandaActual.setConsumidor(demanda.getConsumidor());
		
		
		return demandaService.save(demandaActual);
		
	}
	
	@DeleteMapping("/demandas/{id_demanda}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id_demanda) {
		demandaService.delete(id_demanda);
	}
	
	@GetMapping("/demandas/oferta/{oferta}")
	public List<Demanda> mostrarOfertas(@PathVariable Oferta oferta){
		System.out.println("metodo********************");
		if(oferta == null) {
			System.out.println("pailas bebe");
		}
		else {
			System.out.println(oferta.getCantidadproducto());
			System.out.println(demandaService.findByCantidadproducto(oferta.getCantidadproducto()));
		}
		
		return demandaService.findByCantidadproducto(oferta.getCantidadproducto());
		
	}
	

}
