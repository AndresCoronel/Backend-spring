package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IConsumidorDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Consumidor;

@Service
public class ConsumidorServiceImpl implements IConsumidorService{
	
	@Autowired
	private IConsumidorDao consumidorDao;

	@Override
	@Transactional(readOnly=true)
	public List<Consumidor> findAll() {
		return (List<Consumidor>) consumidorDao.findAll();
		
	}
//	public Consumidor find(String usuario_consumidor) {
//		return consumidorDao.findOneByUsername(usuario_consumidor);
//	}
	
	

	@Override
	@Transactional(readOnly=true)
	public Consumidor findByCedulaConsumidor(Long cedula_consumidor) {
		// TODO Auto-generated method stub
		return consumidorDao.findById(cedula_consumidor).orElse(null);
	}
	@Override
	@Transactional(readOnly=true)
	public Consumidor buscarConsumidorCorreo(String correo_consumidor, String contrasenia_consumidor) {
		// TODO Auto-generated method stub
		System.out.println("llego aqiii");
		Consumidor consumidor = consumidorDao.buscarConsumidorCorreo(correo_consumidor, contrasenia_consumidor);
		return consumidor;
	}
	
	@Override
	@Transactional
	public Consumidor save(Consumidor consumidor) {
		// TODO Auto-generated method stub
		return consumidorDao.save(consumidor);
	}
	@Override
	@Transactional
	public void delete(Long cedula_consumidor) {
		// TODO Auto-generated method stub
		consumidorDao.deleteById(cedula_consumidor);
		
	}

}
