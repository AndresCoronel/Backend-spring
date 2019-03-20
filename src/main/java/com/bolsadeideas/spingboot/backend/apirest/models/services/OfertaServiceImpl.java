package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IOfertaDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;

@Service
public class OfertaServiceImpl implements IOfertaService{

	@Autowired
	private IOfertaDao ofertaDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Oferta> findAll() {
		return (List<Oferta>) ofertaDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Oferta findByIdOferta(Long id_oferta) {
		return ofertaDao.findById(id_oferta).orElse(null);
	}

	@Override
	@Transactional
	public Oferta save(Oferta oferta) {
		// TODO Auto-generated method stub
		return ofertaDao.save(oferta);
	}

	@Override
	@Transactional
	public void delete(Long id_oferta) {
		ofertaDao.deleteById(id_oferta);
		
	}

}
