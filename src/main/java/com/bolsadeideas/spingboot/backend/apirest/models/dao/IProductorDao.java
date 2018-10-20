package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

public interface IProductorDao extends CrudRepository<Productor, Long> {

}
