package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Testimonio;

public interface ITestimonioDao extends CrudRepository<Testimonio, Long>  {

}
