package com.ibm.academia.restapi.tarjetas.servicios;

import java.util.Optional;

import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;
import com.ibm.academia.restapi.tarjetas.modelo.entidad.Preferencia;

public interface PreferenciaDAO extends GenericoDAO<Preferencia>
{
	public Optional<Preferencia> buscarTipoTarjeta(TipoPasion tipoPasion , Integer Edad, Integer Salario);
}
