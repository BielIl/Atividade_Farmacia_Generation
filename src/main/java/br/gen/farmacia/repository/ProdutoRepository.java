package br.gen.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gen.farmacia.model.ProdutoModel;

/*
 * @version v1 - Desenvolvimento Controller Produto (crud básico)
 * @since 29-01-2022
 * @author Grupo 2 Turma 42 - Generation Brasil
 */

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);


	
}
