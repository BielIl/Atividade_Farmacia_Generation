package br.gen.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gen.farmacia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllBySetorContainingIgnoreCase(String setor);
	
	public List<Categoria> findAllByRequerimentoContainingIgnoreCase(String requerimento);


}
