package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;



public interface ICiudadService{
	
	public List<Ciudad>findAll();
	
	public Ciudad findByIdCiudad(int id_ciudad);
	
	public Ciudad save(Ciudad ciudad);
	
	public void delete(int id_ciudad);
	


}


