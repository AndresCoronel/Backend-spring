package com.bolsadeideas.spingboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

public interface IOfertaDao extends CrudRepository<Oferta, Long> {
	
	List<Oferta> findByProductor(Productor cedula_productor);
	List<Oferta> buscarIguales(String nombre_producto, int cantidad_producto, String unidad_medida_producto);
	List<Oferta> buscarMenores(String nombre_producto, int cantidad_producto, String unidad_medida_producto);

}
