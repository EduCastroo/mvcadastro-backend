package br.com.mv.mvcadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.mvcadastro.model.Projetos;

@Repository
public interface ProjetoRepository extends JpaRepository<Projetos, Long > {
	
	public List<Projetos> findAllByNomeProjetoContainingIgnoreCase (String nomeProjeto);
	
}
