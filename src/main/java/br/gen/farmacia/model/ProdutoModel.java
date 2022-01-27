package br.gen.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private Long id;
}
