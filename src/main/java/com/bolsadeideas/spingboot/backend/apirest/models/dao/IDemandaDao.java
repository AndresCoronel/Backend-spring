package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;


public interface IDemandaDao extends CrudRepository<Demanda, Long> {

	@SuppressWarnings("unchecked")
	Demanda save(Demanda demanda);
	
}
