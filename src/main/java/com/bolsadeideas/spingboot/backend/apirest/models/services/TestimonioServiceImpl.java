package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bolsadeideas.spingboot.backend.apirest.models.dao.ITestimonioDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Testimonio;

@Service
public class TestimonioServiceImpl implements ItestimonioService {
	
	@Autowired
	private ITestimonioDao testimonioDao;

	@Override
	@Transactional(readOnly=true)
	public List<Testimonio> findAll() {
		return (List<Testimonio>) testimonioDao.findAll();
		
	}
	@Override
	@Transactional(readOnly=true)
	public Testimonio findByIdTestimonio(Long id_testimonio) {
		// TODO Auto-generated method stub
		return testimonioDao.findById(id_testimonio).orElse(null);
	}
	@Override
	@Transactional
	public Testimonio save(Testimonio testimonio) {
		// TODO Auto-generated method stub
		return testimonioDao.save(testimonio);
	}
	@Override
	@Transactional
	public void delete(Long id_testimonio) {
		// TODO Auto-generated method stub
		testimonioDao.deleteById(id_testimonio);
		
	}

}
