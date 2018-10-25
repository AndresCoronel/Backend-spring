package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;


public interface IOfertaService {
	
	public List<Oferta>findAll();	
	public Oferta findByIdOferta(Long id_oferta);
	public Oferta save(Oferta oferta);	
	public void delete(Long id_oferta);
}



