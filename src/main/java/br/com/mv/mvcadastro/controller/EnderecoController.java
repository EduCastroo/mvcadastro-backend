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

import br.com.mv.mvcadastro.model.Endereco;
import br.com.mv.mvcadastro.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {

	

		
		@Autowired
		private EnderecoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Endereco>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<Endereco> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/endereco/{rua}")
		public ResponseEntity<List<Endereco>> GetByTitulo(@PathVariable("rua") String rua){
			return ResponseEntity.ok(repository.findByRuaContainingIgnoreCase(rua));
		}
		
		@PostMapping
		public ResponseEntity<Endereco> post (@Valid @RequestBody Endereco endereco){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
		}
		
		@PutMapping
		public ResponseEntity<Endereco> put (@Valid @RequestBody Endereco endereco){
			return repository.findById(endereco.getIdEndereco())
					.map(resp -> ResponseEntity.status(HttpStatus.OK).body(repository.save(endereco)))
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
			
					
		}
		
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			 Optional<Endereco> post = repository.findById(id);
		        if(post.isEmpty())
			        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		        repository.deleteById(id);
		}
	}
	
