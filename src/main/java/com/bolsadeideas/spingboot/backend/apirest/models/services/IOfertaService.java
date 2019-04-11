package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;


public interface IOfertaService {
	
	public List<Oferta>findAll();	
	public Oferta findByIdOferta(Long id_oferta);
	public Oferta save(Oferta oferta);	
	public void delete(Long id_oferta);
	
	/*Traer ofertas por cedula del productor*/
	public List<Oferta> findByProductor(Productor productor);
	/*Ofertas para la demanda*/
	public List<Oferta> buscarIguales(String nombre_producto, int cantidad_producto, String unidad_medida_producto);
	public List<Oferta> buscarMenores(String nombre_producto, int cantidad_producto, String unidad_medida_producto);
	
}



