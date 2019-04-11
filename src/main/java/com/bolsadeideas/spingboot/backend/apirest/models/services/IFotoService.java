package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Foto;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

public interface IFotoService {
	
	public List<Foto>findAll();	
	public Foto save(Foto foto);	
	public void delete(Long id_foto);

}
