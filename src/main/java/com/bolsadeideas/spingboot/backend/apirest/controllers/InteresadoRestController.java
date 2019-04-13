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
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Interesado;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.DemandaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.InteresadoPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.OfertaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IDemandaService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IInteresadoService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IOfertaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class InteresadoRestController {
	
	@Autowired
	private IInteresadoService interesadoService;
	@Autowired
	private IConsumidorService consumidorService;
	@Autowired
	private IOfertaService ofertaService;
	
	
	@GetMapping("/interesados")
	public List<Interesado> index(){
		return interesadoService.findAll();
	}
	@GetMapping("/interesados/{id_interesado}")
	public Interesado show(@PathVariable Long id_interesado) {
		return interesadoService.findByIdInteresado(id_interesado);
	}
	
	@GetMapping("/interesados/consumidor/{consumidor}")
	public List<Interesado> mostrarOfertasInteres(@PathVariable Consumidor consumidor) {
		System.out.println("entro");
		System.out.println("mira donde llego el interesado"+ consumidor.getCorreo_consumidor()	);
		return interesadoService.findByConsumidor(consumidor);

	}
	
	@PostMapping("/interesados/post/{consumidor}/{oferta}")
	@ResponseStatus(HttpStatus.CREATED)
	public Interesado create(@RequestBody InteresadoPojo interesadoPojo, Consumidor consumidorV, Oferta ofertaV) {
	Interesado interesado = new Interesado();
	
	Consumidor consumidor = this.consumidorService.findByCedulaConsumidor(consumidorV.getCedula_consumidor());
	System.out.println("llego el consumidor: "+consumidor);
	Oferta oferta = this.ofertaService.findByIdOferta(ofertaV.getId_oferta());
	System.out.println("Llego la oferta: "+oferta.getNombre_producto());
	
		interesado.setConsumidor(consumidor);
		interesado.setOferta(oferta);
		
		return interesadoService.save(interesado);
		
	}
	
	@PutMapping("/interesados/{id_interesado}")
	@ResponseStatus(HttpStatus.CREATED)
	public Interesado update(@RequestBody Interesado interesado, @PathVariable Long id_interesado) {
		Interesado interesadoActual= interesadoService.findByIdInteresado(id_interesado);
		
		interesadoActual.setConsumidor(interesado.getConsumidor());
		interesadoActual.setOferta(interesado.getOferta());
		
		return interesadoService.save(interesadoActual);
		
	}
	
	@DeleteMapping("/interesados/{id_interesado}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id_interesado) {
		interesadoService.delete(id_interesado);
	}

}
