package com.bolsadeideas.spingboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.spingboot.backend.apirest.models.dao.IFotoDao;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Foto;

@Service
public class FotoServiceImpl implements IFotoService {
	
	private IFotoDao fotoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Foto> findAll() {
		// TODO Auto-generated method stub
		return (List<Foto>) fotoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Foto save(Foto foto) {
		// TODO Auto-generated method stub
		return this.fotoDao.save(foto);
	}

	@Override
	public void delete(Long id_foto) {
		// TODO Auto-generated method stub
		fotoDao.deleteById(id_foto);
	}

}
