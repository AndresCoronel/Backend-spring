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
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Foto;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.DemandaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.OfertaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IConsumidorService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IDemandaService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IFotoService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IOfertaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class FotoController {

	@Autowired
	private IFotoService fotoService;
	@Autowired
	private IOfertaService ofertaService;

	@GetMapping("/fotos")
	public List<Foto> index() {
		return fotoService.findAll();
	}

	@PostMapping("/fotos/ofertas")
	@ResponseStatus(HttpStatus.CREATED)
	public Foto create(@RequestBody OfertaPojo ofertaPojo) {
		Foto foto = new Foto();
		
		Oferta ofertaActual = ofertaService.findByIdOferta(ofertaPojo.getId_oferta());
		
		foto.setOferta(ofertaActual);
		foto.setUrl_foto(foto.getUrl_foto());
		
		
		return foto;

	}

}
