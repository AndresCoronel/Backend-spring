package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.ICiudadDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;

@Service
public class CiudadServiceImpl implements ICiudadService{
	
	@Autowired
	private ICiudadDao ciudadDao;

	@Override
	@Transactional(readOnly=true)
	public List<Ciudad> findAll() {
		return (List<Ciudad>) ciudadDao.findAll();
		
	}	

	@Override
	@Transactional(readOnly=true)
	public Ciudad findByIdCiudad(int id_ciudad) {
		// TODO Auto-generated method stub
		return ciudadDao.findById(id_ciudad).orElse(null);
	}
	@Override
	@Transactional
	public Ciudad save(Ciudad ciudad) {
		// TODO Auto-generated method stub
		return ciudadDao.save(ciudad);
	}
	@Override
	@Transactional
	public void delete(int id_ciudad) {
		// TODO Auto-generated method stub
		ciudadDao.deleteById(id_ciudad);
		
	}

}
