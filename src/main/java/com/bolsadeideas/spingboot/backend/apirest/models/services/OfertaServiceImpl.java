package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IDemandaDao;
import com.bolsadeideas.spingboot.backend.apirest.models.dao.IOfertaDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

@Service
public class OfertaServiceImpl implements IOfertaService{

	@Autowired
	private IOfertaDao ofertaDao;
	private IDemandaDao demandaDao;
	/*Traer todas las ofertas*/
	@Override
	@Transactional(readOnly=true)
	public List<Oferta> findAll() {
		return (List<Oferta>) ofertaDao.findAll();
	}

	/*Buscar oferta por id*/
	@Override
	@Transactional(readOnly=true)
	public Oferta findByIdOferta(Long id_oferta) {
		return ofertaDao.findById(id_oferta).orElse(null);
	}
	
	/*Buscar oferta por productor*/
	@Override
	@Transactional(readOnly=true)
	public List<Oferta> findByProductor(Productor productor) { 
		return ofertaDao.findByProductor(productor); 
	}
		
	/*Guardar las ofertas*/
	@Override
	@Transactional
	public Oferta save(Oferta oferta) {
		// TODO Auto-generated method stub
		return ofertaDao.save(oferta);
	}

	/*Borrar ofertas por id*/
	@Override
	@Transactional
	public void delete(Long id_oferta) {
		ofertaDao.deleteById(id_oferta);
		
	}

	@Override
	public List<Oferta> buscarIguales(String nombre_producto, int cantidad_producto, String unidad_medida_producto) {
		// TODO Auto-generated method stub
		List<Oferta> ofertas = (List<Oferta>) ofertaDao.buscarIguales(nombre_producto, cantidad_producto, unidad_medida_producto);
		return ofertas;
	}
	
	@Override
	public List<Oferta> buscarMenores(String nombre_producto, int cantidad_producto, String unidad_medida_producto) {
		// TODO Auto-generated method stub
		List<Oferta> ofertas = (List<Oferta>) ofertaDao.buscarMenores(nombre_producto, cantidad_producto, unidad_medida_producto);
		return ofertas;
	}
	
	
}
