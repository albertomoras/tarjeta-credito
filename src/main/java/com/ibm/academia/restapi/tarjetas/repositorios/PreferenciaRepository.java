package com.ibm.academia.restapi.tarjetas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.restapi.tarjetas.modelo.entidad.Preferencia;

public interface PreferenciaRepository extends CrudRepository<Preferencia, Long>
{

}
