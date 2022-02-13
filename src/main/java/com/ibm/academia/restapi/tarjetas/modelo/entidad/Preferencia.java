package com.ibm.academia.restapi.tarjetas.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="preferencias", schema = "perfil")
public class Preferencia implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="salario_minimo", nullable = false)
	private Double salarioMinimo;
	
	@Column(name="salario_maximo", nullable = false)
	private Double salarioMaximo;
	
	@Column(name="edad_minima", nullable = false)
	private Integer edadMinima;
	
	@Column(name="edad_maxima", nullable = false)
	private Integer edadMaxima;
	
	@Column(name="usuario_creacion", nullable = false)
	private String usuarioCreacion;
	
	@Column(name="fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name="tipo_pasion")
	@Enumerated(EnumType.STRING)
	private TipoPasion tipoPasion;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="preferencia_tarjetas", schema = "perfil",
	joinColumns = @JoinColumn(name="FK_PREFERENCIA", nullable = false),
	inverseJoinColumns = @JoinColumn(name= "FK_TARJETA_CREDITO", nullable = false)) 
	private Set<TarjetaCredito> tarjetasCredito;
	
	
	

	public Preferencia(Long id, Double minSalario, Double maxSalario, Integer minEdad, Integer maxEdad,String usuarioCreacion, TipoPasion tipoPasion) 
	{
		this.id = id;
		this.salarioMinimo = minSalario;
		this.salarioMaximo = maxSalario;
		this.edadMinima = minEdad;
		this.edadMaxima = maxEdad;
		this.usuarioCreacion = usuarioCreacion;
		this.tipoPasion = tipoPasion;
	}
	
	
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Preferencia [id=");
		builder.append(id);
		builder.append(", minSalario=");
		builder.append(salarioMinimo);
		builder.append(", maxSalario=");
		builder.append(salarioMaximo);
		builder.append(", minEdad=");
		builder.append(edadMinima);
		builder.append(", maxEdad=");
		builder.append(edadMaxima);
		builder.append(", usuarioCreacion=");
		builder.append(usuarioCreacion);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append(", tipoPasion=");
		builder.append(tipoPasion);
		builder.append("]");
		return builder.toString();
	}
	
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(id);
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
		Preferencia other = (Preferencia) obj;
		return Objects.equals(id, other.id);
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

	private static final long serialVersionUID = -8947075778060862812L;

}
