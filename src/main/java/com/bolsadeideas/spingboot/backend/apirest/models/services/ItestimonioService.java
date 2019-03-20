package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Testimonio;

public interface ItestimonioService {
	
	public List<Testimonio>findAll();	
	public Testimonio findByIdTestimonio(Long id_testimonio);
	public Testimonio save(Testimonio testimonio);	
	public void delete(Long id_testimonio);

}
