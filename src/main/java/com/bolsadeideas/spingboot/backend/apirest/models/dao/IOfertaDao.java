package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;

public interface IOfertaDao extends CrudRepository<Oferta, Long> {

}
