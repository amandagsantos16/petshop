package com.amanda.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.petshop.domain.Pessoa;
import com.amanda.petshop.repository.PessoaRepository;
import com.amanda.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException(
				"Objeto não encontrado. ID: " + id + ", Tipo: " + Pessoa.class.getName()));
	}

}