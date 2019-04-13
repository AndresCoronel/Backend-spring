package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;


public interface ICiudadDao extends CrudRepository<Ciudad, Integer> {

}
