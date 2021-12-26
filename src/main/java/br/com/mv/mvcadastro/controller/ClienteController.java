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

import br.com.mv.mvcadastro.model.Cliente;
import br.com.mv.mvcadastro.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	
	//@Autowired
	//private ClienteService usuarioService;
	@Autowired
	private ClienteRepository repository;
	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(repository.findAll());
        
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable long id) {
	        return repository.findById(id)
		        .map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Cliente> post (@Valid @RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> put (@Valid @RequestBody Cliente cliente){
		return repository.findById(cliente.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente)))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());	
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		 Optional<Cliente> post = repository.findById(id);
	        if(post.isEmpty())
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	        repository.deleteById(id);
	}
	

}