package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Interesado;

public interface IInteresadoService {
	
	public List<Interesado>findAll();	
	public Interesado findByIdInteresado(Long id_interesado);
	public Interesado save(Interesado interesado);	
	public void delete(Long id_interesado);
}
