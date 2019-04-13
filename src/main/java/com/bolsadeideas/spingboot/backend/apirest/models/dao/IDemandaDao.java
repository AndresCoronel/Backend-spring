package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;


public interface IDemandaDao extends CrudRepository<Demanda, Long> {

	@SuppressWarnings("unchecked")
	Demanda save(Demanda demanda);
	
	List<Demanda> findByConsumidor(Consumidor cedula_consumidor);
	
}
