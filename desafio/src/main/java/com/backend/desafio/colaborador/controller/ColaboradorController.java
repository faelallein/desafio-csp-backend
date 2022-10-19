package com.backend.desafio.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.desafio.colaborador.entity.ColaboradorEntity;
import com.backend.desafio.colaborador.service.ColaboradorService;
import com.backend.desafio.colaborador.to.ColaboradorTO;

@RestController
@RequestMapping(value = "/colaborador", produces = "application/json")
public class ColaboradorController
{
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public List<ColaboradorEntity> getAll(@RequestParam(name = "setorId", required = false) Long setorId, @RequestParam(name = "nome", required = false) String nome)
	{
		return colaboradorService.getAll(setorId, nome);
	}
	
	@GetMapping("/{cpf}")
	public ColaboradorEntity getByCpf(@PathVariable String cpf)
	{
		return colaboradorService.getByCpf(cpf);
	}
	
	@DeleteMapping("/{cpf}")
	public ColaboradorEntity delete(@PathVariable String cpf)
	{
		return colaboradorService.delete(cpf);
	}
	
	@PostMapping
	public ColaboradorEntity save(@RequestBody ColaboradorTO colaborador)
	{
		return colaboradorService.save(colaborador);
	}
}
