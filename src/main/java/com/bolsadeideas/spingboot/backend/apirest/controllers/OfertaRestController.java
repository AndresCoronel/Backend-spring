package com.bolsadeideas.spingboot.backend.apirest.controllers;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.hibernate.*;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Ciudad;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Demanda;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Foto;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Oferta;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;
import com.bolsadeideas.spingboot.backend.apirest.models.pojos.OfertaPojo;
import com.bolsadeideas.spingboot.backend.apirest.models.services.ICiudadService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IOfertaService;
import com.bolsadeideas.spingboot.backend.apirest.models.services.IProductorService;

import util.HibernateUtil;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class OfertaRestController {

	@Autowired
	private IOfertaService ofertaService;
	@Autowired
	private IProductorService productorService;
	@Autowired
	private ICiudadService ciudadService;

	@GetMapping("/ofertas")
	public List<Oferta> index() {
		return ofertaService.findAll();
	}

	@GetMapping("/ofertas/{id_oferta}")
	public Oferta show(@PathVariable Long id_oferta) {

		return ofertaService.findByIdOferta(id_oferta);
	}

	@GetMapping("/ofertas/productor/{productor}")
	public List<Oferta> mostrar(@PathVariable Productor productor) {

		Productor produc = this.productorService.findByCedulaProductor(productor.getCedula_productor());
		System.out.println("esto llego de la consulta " + produc.getNombre_productor());
		System.out.println("****************" + productor.getCorreo_productor());
		System.out.println("la oferta que encontro" + productor + ofertaService.findByProductor(productor));
		return ofertaService.findByProductor(productor);

	}

	@GetMapping("/ofertas/demanda/exacto/{demanda}")
	public List<Oferta> mostrarOfertas(@PathVariable Demanda demanda) {		
		 List<Oferta> ofertas = (List<Oferta>) ofertaService.buscarIguales(demanda.getNombre_producto(), demanda.getCantidad_producto(), demanda.getMedida_producto());
		return ofertas;

	}
	@GetMapping("/ofertas/demanda/menores/{demanda}")
	public List<Oferta> mostrarOfertasMenores(@PathVariable Demanda demanda) {		
		 List<Oferta> ofertas = (List<Oferta>) ofertaService.buscarMenores(demanda.getNombre_producto(), demanda.getCantidad_producto(), demanda.getMedida_producto());
		return ofertas;

	}


	@PostMapping("/ofertas")
	@ResponseStatus(HttpStatus.CREATED)
	public Oferta create(@RequestBody OfertaPojo ofertaPojo) {

		Oferta oferta = new Oferta();
		Productor productor = this.productorService.findByCedulaProductor(ofertaPojo.getProductor());
		Ciudad ciudad = this.ciudadService.findByIdCiudad(ofertaPojo.getCiudad());
		
		oferta.setCreate_at(new Date());
		oferta.setNombre_producto(ofertaPojo.getNombre_producto());
		oferta.setUnidad_medida_producto(ofertaPojo.getUnidad_medida_producto());
		oferta.setCantidad_producto(ofertaPojo.getCantidad_producto());
		oferta.setPrecio_producto(ofertaPojo.getPrecio_producto());
		oferta.setVariedad_producto(ofertaPojo.getVariedad_producto());
		oferta.setDescripcion_producto(ofertaPojo.getDescripcion_producto());
		oferta.setFecha_recoleccion_oferta(ofertaPojo.getFecha_recoleccion_oferta());
		oferta.setLugar_oferta(ofertaPojo.getLugar_oferta());
		oferta.setEstado_oferta("PUBLICADA");
		oferta.setProductor(productor);
		oferta.setCiudad(ciudad);

		return ofertaService.save(oferta);
	}

	@PutMapping("/ofertas/{id_oferta}")
	public Oferta update(@RequestBody Oferta oferta, @PathVariable Long id_oferta) {
		Oferta ofertaActual = ofertaService.findByIdOferta(id_oferta);

		ofertaActual.setNombre_producto(oferta.getNombre_producto());
		ofertaActual.setUnidad_medida_producto(oferta.getUnidad_medida_producto());
		ofertaActual.setCantidad_producto(oferta.getCantidad_producto());
		ofertaActual.setPrecio_producto(oferta.getPrecio_producto());
		ofertaActual.setVariedad_producto(oferta.getVariedad_producto());
		ofertaActual.setDescripcion_producto(oferta.getVariedad_producto());
		ofertaActual.setLugar_oferta(oferta.getLugar_oferta());
		ofertaActual.setEstado_oferta(oferta.getEstado_oferta());
		ofertaActual.setFecha_recoleccion_oferta(oferta.getFecha_recoleccion_oferta());
		ofertaActual.setProductor(oferta.getProductor());
		
		

		return ofertaService.save(ofertaActual);

	}

	@DeleteMapping("/ofertas/{id_oferta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_oferta) {
		ofertaService.delete(id_oferta);
	}

}
