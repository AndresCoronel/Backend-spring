package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IDemandaDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;

@Service
public class DemandaServiceImpl implements IDemandaService {

	
	@Autowired
	private IDemandaDao demandaDao;

	@Override
	@Transactional(readOnly=true)
	public List<Demanda> findAll() {
		return (List<Demanda>) demandaDao.findAll();
		
	}
	@Override
	@Transactional(readOnly=true)
	public Demanda findByIdDemanda(Long id_demanda) {
		// TODO Auto-generated method stub
		return demandaDao.findById(id_demanda).orElse(null);
	}
	@Override
	@Transactional
	public Demanda save(Demanda demanda) {
		// TODO Auto-generated method stub
		return this.demandaDao.save(demanda);
	}
	@Override
	@Transactional
	public void delete(Long id_demanda) {
		// TODO Auto-generated method stub
		demandaDao.deleteById(id_demanda);
		
	}
	
	
}
