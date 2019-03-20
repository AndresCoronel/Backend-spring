package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Interesado;


public interface IInteresadoDao extends CrudRepository<Interesado, Long> {

	
}
