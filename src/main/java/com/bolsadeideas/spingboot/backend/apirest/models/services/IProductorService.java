package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

public interface IProductorService {
	
	public List<Productor>findAll();	
	public Productor findByCedulaProductor(Long cedula_productor);
	public Productor save(Productor cedula_productor);	
	public void delete(Long cedula_productor);
	
	public Productor buscarProductorCorreo(String correo_productor, String contrasenia_Productor);
}
