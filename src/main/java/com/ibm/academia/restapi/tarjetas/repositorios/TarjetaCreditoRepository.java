package com.ibm.academia.restapi.tarjetas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ibm.academia.restapi.tarjetas.modelo.entidad.TarjetaCredito;

public interface TarjetaCreditoRepository extends CrudRepository<TarjetaCredito, Long>
{

}
