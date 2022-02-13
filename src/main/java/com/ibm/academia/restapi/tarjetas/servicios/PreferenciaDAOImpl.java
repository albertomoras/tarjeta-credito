package com.ibm.academia.restapi.tarjetas.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;
import com.ibm.academia.restapi.tarjetas.modelo.entidad.Preferencia;
import com.ibm.academia.restapi.tarjetas.repositorios.PreferenciaRepository;

@Service
public class PreferenciaDAOImpl extends GenericoDAOImpl<Preferencia, PreferenciaRepository> implements PreferenciaDAO
{
	
	@Autowired
	public PreferenciaDAOImpl(PreferenciaRepository repository) 
	{
		super(repository);
	}

	@Override
	public Optional<Preferencia> buscarTipoTarjeta(TipoPasion tipoPasion, Integer Edad, Integer Salario) {
		// TODO Auto-generated method stub
		return null;
	}

}
