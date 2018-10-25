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

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IDemandaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DemandaRestController {
	
	@Autowired
	private IDemandaService demandaService;
	
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
	public Demanda create(@RequestBody Demanda demanda) {
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
		
		demandaActual.setConsumidor(demanda.getConsumidor());
		
		
		return demandaService.save(demandaActual);
		
	}
	
	@DeleteMapping("/demandas/{id_demanda}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id_demanda) {
		demandaService.delete(id_demanda);
	}

}
