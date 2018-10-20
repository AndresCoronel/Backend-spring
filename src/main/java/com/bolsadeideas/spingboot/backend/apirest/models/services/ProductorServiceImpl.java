package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IProductorDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

@Service
public class ProductorServiceImpl implements IProductorService  {
	@Autowired
	private IProductorDao productorDao;

	@Override
	@Transactional(readOnly=true)
	public List<Productor> findAll() {
		return (List<Productor>) productorDao.findAll();
		
	}
	@Override
	@Transactional(readOnly=true)
	public Productor findByCedulaProductor(Long cedula_productor) {
		// TODO Auto-generated method stub
		return productorDao.findById(cedula_productor).orElse(null);
	}
	@Override
	@Transactional
	public Productor save(Productor productor) {
		// TODO Auto-generated method stub
		return productorDao.save(productor);
	}
	@Override
	@Transactional
	public void delete(Long cedula_productor) {
		// TODO Auto-generated method stub
		productorDao.deleteById(cedula_productor);
		
	}
}
