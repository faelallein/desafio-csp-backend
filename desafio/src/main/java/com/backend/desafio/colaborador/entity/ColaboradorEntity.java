package com.backend.desafio.colaborador.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.backend.desafio.setor.entity.SetorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "colaborador")
@Table(name = "colaborador")
public class ColaboradorEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	
	@OneToOne
	@JoinColumn(name = "setorId")
	private SetorEntity setor;
	
	private Date dataNascimento;

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getCpf()
	{
		return cpf;
	}
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getTelefone()
	{
		return telefone;
	}
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	public SetorEntity getSetor()
	{
		return setor;
	}
	public void setSetor(SetorEntity setorId)
	{
		this.setor = setorId;
	}
	public Date getDataNascimento()
	{
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
	
	
}
