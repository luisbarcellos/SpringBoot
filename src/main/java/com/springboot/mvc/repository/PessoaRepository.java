package com.springboot.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.mvc.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	List<Pessoa> findAll();
	
	List<Pessoa> findByNome(String nome);
	
	List<Pessoa> findByIdade(int idade);
}
