package br.com.mv.mvcadastro.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.mvcadastro.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long > {
		
		public List <Endereco> findByRuaContainingIgnoreCase(String rua);
		
	}
