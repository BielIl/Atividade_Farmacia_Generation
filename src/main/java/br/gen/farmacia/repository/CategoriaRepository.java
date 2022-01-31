package br.gen.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gen.farmacia.model.Categoria;

/*
 *  Métodos utilizados para pesquisar Setor e requerimento.
 * @return Lista de Postagens
 * @version 1.0
 * @since 29-01-2022
 * @author Grupo 2 Turma 42 - Generation Brasil
 */


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllBySetorContainingIgnoreCase(String setor);
	
	public List<Categoria> findAllByRequerimentoContainingIgnoreCase(String requerimento);


}
