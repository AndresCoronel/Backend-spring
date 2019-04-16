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

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.DemandaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.ICiudadService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IDemandaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DemandaRestController {

	@Autowired
	private IDemandaService demandaService;
	@Autowired
	private IConsumidorService consumidorService;
	@Autowired 
	private ICiudadService ciudadService;

	@GetMapping("/demandas")
	public List<Demanda> index() {
		return demandaService.findAll();
	}

	@GetMapping("/demandas/{id_demanda}")
	public Demanda show(@PathVariable Long id_demanda) {
		return demandaService.findByIdDemanda(id_demanda);
	}
	
	@GetMapping("/demandas/consumidor/{consumidor}")
	public List<Demanda> mostrar(@PathVariable Consumidor consumidor) {
		System.out.println("mira donde llego"+ consumidor.getCorreo_consumidor()	);
		return demandaService.findByConsumidor(consumidor);

	}
	

	@PostMapping("/demandas")
	@ResponseStatus(HttpStatus.CREATED)
	public Demanda create(@RequestBody DemandaPojo demandaPojo) {
		
		Demanda demanda = new Demanda();
		Consumidor consumidor = this.consumidorService.findByCedulaConsumidor(demandaPojo.getConsumidor());
		Ciudad ciudad = this.ciudadService.findByIdCiudad(demandaPojo.getCiudad());
		
		demanda.setCreate_at(new Date());
		demanda.setNombre_producto(demandaPojo.getNombre_producto());
		demanda.setCantidad_producto(demandaPojo.getCantidad_producto());
		demanda.setMedida_producto(demandaPojo.getMedida_producto());
		demanda.setDescripcion_demanda(demandaPojo.getDescripcion_demanda());
		demanda.setEstado_demanda("PUBLICADA");
		demanda.setVariedad_producto(demandaPojo.getVariedad_producto());
		demanda.setDireccion_demanda(demandaPojo.getDireccion_demanda());
		demanda.setConsumidor(consumidor);
		demanda.setCiudad(ciudad);

		return demandaService.save(demanda);

	}

	@PutMapping("/demandas/{id_demanda}")
	@ResponseStatus(HttpStatus.CREATED)
	public Demanda update(@RequestBody Demanda demanda, @PathVariable Long id_demanda) {
		Demanda demandaActual = demandaService.findByIdDemanda(id_demanda);

		demandaActual.setNombre_producto(demanda.getNombre_producto());
		demandaActual.setCantidad_producto(demanda.getCantidad_producto());
		demandaActual.setMedida_producto(demanda.getMedida_producto());
		demandaActual.setDescripcion_demanda(demanda.getDescripcion_demanda());

		demandaActual.setEstado_demanda("PUBLICADA");
		demandaActual.setVariedad_producto(demanda.getVariedad_producto());
		demandaActual.setDireccion_demanda(demanda.getDireccion_demanda());

		demandaActual.setConsumidor(demanda.getConsumidor());

		return demandaService.save(demandaActual);

	}

	@DeleteMapping("/demandas/{id_demanda}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_demanda) {
		demandaService.delete(id_demanda);
	}

	@GetMapping("/demandas/oferta/{oferta}")
	public List<Demanda> mostrarOfertas(@PathVariable Oferta oferta) {
		System.out.println("metodo********************");
		if (oferta == null) {
			System.out.println("pailas bebe");
		} else {
			System.out.println(oferta.getCantidad_producto());
		}

		return null;

	}

}
