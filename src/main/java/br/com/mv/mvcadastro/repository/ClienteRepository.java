package br.com.mv.mvcadastro.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.mvcadastro.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long >{

			
			public Optional<Cliente>findByCnpj (String cnpj);
			public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
		}
	
