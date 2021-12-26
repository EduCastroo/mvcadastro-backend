package br.com.mv.mvcadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.mv.mvcadastro.model.Projetos;
import br.com.mv.mvcadastro.repository.ProjetoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Projetos>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projetos> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/projetos/{projetos}")
	public ResponseEntity<List<Projetos>> getByName(@PathVariable String nomeProjeto){
		return ResponseEntity.ok(repository.findAllByNomeProjetoContainingIgnoreCase(nomeProjeto));
	}
	
	@PostMapping
	public ResponseEntity<Projetos> post (@Valid @RequestBody Projetos projetos){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(projetos));
	}

	@PutMapping
	public ResponseEntity<Projetos> put (@Valid @RequestBody Projetos projetos){
		return repository.findById(projetos.getCodigoProjeto())
		        .map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(repository.save(projetos)))
		        .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());				
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{codigoProjeto}")
	public void delete(@PathVariable long codigoProjeto) {
		 Optional<Projetos> tema = repository.findById(codigoProjeto);
	        if(tema.isEmpty())
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		repository.deleteById(codigoProjeto);
	}
	
}