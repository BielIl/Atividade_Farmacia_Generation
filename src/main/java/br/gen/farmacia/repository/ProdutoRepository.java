package br.gen.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gen.farmacia.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
}
