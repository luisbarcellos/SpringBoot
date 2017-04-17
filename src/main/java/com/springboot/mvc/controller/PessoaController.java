package com.springboot.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.mvc.entity.Pessoa;
import com.springboot.mvc.repository.PessoaRepository;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaController(PessoaRepository pessoaRepository){
		this.pessoaRepository = pessoaRepository;
	}
	
	@RequestMapping(value = "/listarPessoas", method = RequestMethod.GET)
	public String listaPessoas(Model model){
		List<Pessoa> listaPessoas = pessoaRepository.findAll();
		if(listaPessoas != null){
			model.addAttribute("pessoas", listaPessoas);
		}
		return "listaPessoas";
	}
	
 /*@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public String listaPessoasPorNome(@PathVariable("nome") String nome, Model model){
		List<Pessoa> listaPessoas = pessoaRepository.findByNome(nome);
		if(listaPessoas != null){
			model.addAttribute("pessoas", listaPessoas);
		}
		return "listaPessoas";
	}
	*/
	@RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
	public String adicionaPessoa(Pessoa pessoa){
		//pessoa.setNome(nome);
		pessoaRepository.save(pessoa);
		return "redirect:/pessoas/listarPessoas";
	}
}