package com.backend.desafio.colaborador.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.backend.desafio.colaborador.entity.ColaboradorEntity;
import com.backend.desafio.colaborador.to.ColaboradorTO;
import com.backend.desafio.exception.ExceptionValidator;
import com.backend.desafio.setor.entity.SetorEntity;

@Service
public class ColaboradorService
{	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings({ "unchecked" })
	public List<ColaboradorEntity> getAll(Long setorId, String nome)
	{		
		StringBuilder query = new StringBuilder("select c from colaborador c");
		
		if (setorId != null)
		{
			query.append(" where c.setor.id = :setorId");
		}
		
		if (nome != null && nome.isBlank() != true)
		{
			query.append(query.indexOf(" where") < 0 ? " where" : " and" );
			query.append(" c.nome like UPPER(:nome)");
		}		
		
		Query q = entityManager.createQuery(query.toString());
		
		if ( setorId != null )
		{
			q.setParameter("setorId", setorId);
		}			
		
		if ( nome != null && nome.isBlank() != true)
		{
			q.setParameter("nome", "%"+nome+"%");
		}
		
		return q.getResultList();
	}
	
	public ColaboradorEntity getByCpf(String cpf)
	{		
		List<ColaboradorEntity> colaborador = entityManager.createQuery("select c from colaborador c where cpf like :cpf", ColaboradorEntity.class)
			   .setParameter("cpf", cpf)
			   .setMaxResults(1)
			   .getResultList();
		 
		 return colaborador.isEmpty() ? null : colaborador.get(0);
	}
	
	@Transactional
	public ColaboradorEntity delete(String cpf)
	{		
		ColaboradorEntity colaborador = getByCpf(cpf);
		
		if (colaborador == null) {
			throw new ExceptionValidator("missing");
		}
		
		entityManager.remove(colaborador);
		
		return colaborador;				
	}
	
	@Transactional
	public ColaboradorEntity save(ColaboradorTO colaborador)
	{		
		colaborador.setCpf(fixCpf(colaborador.getCpf()));
		
		if (!validate(colaborador))
		{
			return null;
		}

		ColaboradorEntity entity = getByCpf(colaborador.getCpf());
		
		if (entity == null ) 
		{
			entity = new ColaboradorEntity();
		}

		entity.setCpf(colaborador.getCpf());
		entity.setNome(colaborador.getNome().toUpperCase());
		entity.setEmail(colaborador.getEmail());
		entity.setTelefone(colaborador.getTelefone());
		entity.setDataNascimento(colaborador.getDataNascimento());
		entity.setSetor(new SetorEntity(colaborador.getSetorId()));
		
		return entityManager.merge(entity);
	}
	
	private String fixCpf(String cpf)
	{
		if (cpf == null)
		{
			return null;
		}

		return cpf.replaceAll("\\D", "");
	}
	
	private boolean validate(ColaboradorTO colaborador) 
	{		
		if (!validName(colaborador.getNome()))
		{
			throw new ExceptionValidator("invalid_name");
		}
		
		if (colaborador.getCpf().length() < 11 )
		{
			throw new ExceptionValidator("invalid_cpf");
		}
		
		return true; 
	}
	
	private boolean validName(String nome)
	{		
		if (nome.split(" ").length < 2 || nome.trim().length() < 3)
		{
			return false;
		}
		
		return true;
	}
}
