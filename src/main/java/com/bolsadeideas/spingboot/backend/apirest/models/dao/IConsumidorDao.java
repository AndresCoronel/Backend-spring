package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;


public interface IConsumidorDao extends CrudRepository<Consumidor, Long> {
	Consumidor buscarConsumidorCorreo(String correo_consumidor, String contrasenia_consumidor);
}
