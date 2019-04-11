package com.bolsadeideas.spingboot.backend.apirest.models.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bolsadeideas.spingboot.backend.apirest.models.entity.Foto;
import com.bolsadeideas.spingboot.backend.apirest.models.entity.Productor;

public class OfertaPojo {
	
	private Long id_oferta;
	private String nombreproducto;
	private String unidad_medida_producto;
	private int cantidadproducto;
	private int precio_producto;
	private String variedad_producto;
	private String descripcion_producto;
	private Double latitud_oferta;
	private Double longitud_oferta;
	private String lugar_oferta;
	private String estado_oferta;
	private Long productor;
	private String fecha_recoleccion_oferta;
	private String ciudad_oferta;
	private String departamento_oferta;
	private List<Foto> fotos ;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date create_at;
	
	@PrePersist
	public void prePersist() {
		create_at = new Date();
	}

	public OfertaPojo() {
		super();
	}
	

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Long getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(Long id_oferta) {
		this.id_oferta = id_oferta;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public String getUnidad_medida_producto() {
		return unidad_medida_producto;
	}

	public void setUnidad_medida_producto(String unidad_medida_producto) {
		this.unidad_medida_producto = unidad_medida_producto;
	}
	public int getCantidadproducto() {
		return cantidadproducto;
	}

	public void setCantidadproducto(int cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getVariedad_producto() {
		return variedad_producto;
	}

	public void setVariedad_producto(String variedad_producto) {
		this.variedad_producto = variedad_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public Double getLatitud_oferta() {
		return latitud_oferta;
	}

	public void setLatitud_oferta(Double latitud_oferta) {
		this.latitud_oferta = latitud_oferta;
	}

	public Double getLongitud_oferta() {
		return longitud_oferta;
	}

	public void setLongitud_oferta(Double longitud_oferta) {
		this.longitud_oferta = longitud_oferta;
	}

	public String getLugar_oferta() {
		return lugar_oferta;
	}

	public void setLugar_oferta(String lugar_oferta) {
		this.lugar_oferta = lugar_oferta;
	}

	public String getEstado_oferta() {
		return estado_oferta;
	}

	public void setEstado_oferta(String estado_oferta) {
		this.estado_oferta = estado_oferta;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Long getProductor() {
		return productor;
	}

	public void setProductor(Long productor) {
		this.productor = productor;
	}

	public String getFecha_recoleccion_oferta() {
		return fecha_recoleccion_oferta;
	}

	public void setFecha_recoleccion_oferta(String fecha_recoleccion_oferta) {
		this.fecha_recoleccion_oferta = fecha_recoleccion_oferta;
	}

	public String getCiudad_oferta() {
		return ciudad_oferta;
	}

	public void setCiudad_oferta(String ciudad_oferta) {
		this.ciudad_oferta = ciudad_oferta;
	}

	public String getDepartamento_oferta() {
		return departamento_oferta;
	}

	public void setDepartamento_oferta(String departamento_oferta) {
		this.departamento_oferta = departamento_oferta;
	}
	
	
	
	
	
	
	
}
