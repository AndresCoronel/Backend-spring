package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IInteresadoDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Interesado;

@Service
public class InteresadoServiceImpl implements IInteresadoService{
	
	@Autowired
	private IInteresadoDao interesadoDao;

	@Transactional(readOnly=true)
	public List<Interesado> findAll() {
		return (List<Interesado>) interesadoDao.findAll();
		
	}
	@Transactional(readOnly=true)
	public Interesado findByIdInteresado(Long id_interesado) {
		// TODO Auto-generated method stub
		return interesadoDao.findById(id_interesado).orElse(null);
	}
	
	/*Buscar oferta interesada por consumidor*/
	@Override
	@Transactional(readOnly=true)
	public List<Interesado> findByConsumidor(Consumidor consumidor) { 
		System.out.println("entro2");
		return interesadoDao.findByConsumidor(consumidor); 
	}
	
	
	@Transactional
	public Interesado save(Interesado interesado) {
		// TODO Auto-generated method stub
		return this.interesadoDao.save(interesado);
	}
	
	@Transactional
	public void delete(Long id_interesado) {
		// TODO Auto-generated method stub
		interesadoDao.deleteById(id_interesado);
		
	}

}
