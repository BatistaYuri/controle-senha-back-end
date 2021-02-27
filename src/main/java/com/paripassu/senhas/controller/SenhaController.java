package com.paripassu.senhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paripassu.senhas.models.Senha;
import com.paripassu.senhas.repository.SenhaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SenhaController {
	
	@Autowired
	SenhaRepository senhaRepository;
	
	@ApiOperation(value="Retorna lista de senhas")
	@GetMapping("/senhas")
	public List<Senha> get(){
		return senhaRepository.findProximasSenha();
	}
	
	@ApiOperation(value="Retorna lista de senhas")
	@GetMapping("/senhaAtual")
	public Senha getSenhaAtual(){
		return senhaRepository.findByStatus();
	}
	
	@ApiOperation(value="Salva uma senha")
	@PostMapping("/senha")
	public Senha save(@RequestBody Senha senha) {
		return senhaRepository.save(senha);
	}
	
	@ApiOperation(value="Deleta um senha")
	@PostMapping("/chamar/{idProx}")
	public void ChamarSenha(@PathVariable("idProx") long idProx, @RequestBody(required = false) Senha senhaAtual) {
		if(senhaAtual != null) {
			senhaRepository.deleteById(senhaAtual.getId());
		}
		senhaRepository.alterarStatus(idProx);
	}
	
	@ApiOperation(value="Reiniciar contagem")
	@DeleteMapping("/deletar")
	public void deleteAll() {
		senhaRepository.deleteAll();
		senhaRepository.resetKey();
	}
	
	
}
