package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;


public interface IConsumidorService  {

	public List<Consumidor>findAll();
	
	public Consumidor findByCedulaConsumidor(Long cedula_consumidor);
	
	public Consumidor save(Consumidor consumidor);
	
	public void delete(Long cedula_consumidor);
}
