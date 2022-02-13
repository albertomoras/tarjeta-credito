package com.ibm.academia.restapi.tarjetas.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="tarjeta_credito", schema = "perfil")
public class TarjetaCredito implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name="cuenta", nullable = false, unique = true, length = 10)
	private Integer cuenta;
	
	@Column (name= "vigencia", nullable = false)
	private Date vigencia; 
	
	@Column(name="usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name="fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@ManyToMany(mappedBy = "tarjetasCredito", fetch = FetchType.LAZY)
	private Set<Preferencia> preferencias;
	
		
	public TarjetaCredito(Long id, String nombre, Integer cuenta, Date vigencia, String usuarioCreacion) 
	{
		this.id = id;
		this.nombre = nombre;
		this.cuenta = cuenta;
		this.vigencia = vigencia;
		this.usuarioCreacion = usuarioCreacion;
	}
	
	
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("TarjetaCredito [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", cuenta=");
		builder.append(cuenta);
		builder.append(", vigencia=");
		builder.append(vigencia);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append("]");
		return builder.toString();
	}
	

	@Override
	public int hashCode() 
	{
		return Objects.hash(cuenta, id);
	}


	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		return Objects.equals(cuenta, other.cuenta) && Objects.equals(id, other.id);
	}
	
	
	@PrePersist
	private void antesPersistir()
	{
		this.fechaCreacion = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.fechaModificacion =  new Date();
	}


	private static final long serialVersionUID = 8112457148935107382L;

}
