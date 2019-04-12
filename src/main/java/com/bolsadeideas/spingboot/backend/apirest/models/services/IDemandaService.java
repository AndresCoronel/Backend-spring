package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;


public interface IDemandaService {

	public List<Demanda>findAll();	
	public Demanda findByIdDemanda(Long id_demanda);
	public Demanda save(Demanda demanda);	
	public void delete(Long id_demanda);

}
