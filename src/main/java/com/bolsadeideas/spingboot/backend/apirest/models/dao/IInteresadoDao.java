package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Interesado;


public interface IInteresadoDao extends CrudRepository<Interesado, Long> {


	List<Interesado> findByConsumidor(Consumidor cedula_consumidor);
}
