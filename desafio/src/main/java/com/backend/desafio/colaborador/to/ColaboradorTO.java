package com.backend.desafio.colaborador.to;

import java.util.Date;

public class ColaboradorTO
{	
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Long setorId;	
	private Date dataNascimento;
	
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
	public Long getSetorId()
	{
		return setorId;
	}
	public void setSetorId(Long setorId)
	{
		this.setorId = setorId;
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
