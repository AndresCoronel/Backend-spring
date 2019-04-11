package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;


public interface IDemandaDao extends CrudRepository<Demanda, Long> {

	@SuppressWarnings("unchecked")
	Demanda save(Demanda demanda);
	List<Demanda> findByCantidadproducto(int cantidadproducto);
	
	
}
