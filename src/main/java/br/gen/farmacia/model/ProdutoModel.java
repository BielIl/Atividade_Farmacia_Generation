package br.gen.farmacia.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * @version v2 (Desenvolvimento Model Produto: atributos, anotações e getters/setters)
 * @since 29-01-2022
 * @author Grupo 2 Turma 42 - Generation Brasil
 */

@Entity
@Table (name = "tb_Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		// TODO Auto-generated method stub
	
		return null;
	
	}
	@NotNull
	private String nome;

	public synchronized String getNome() {
		return nome;
	}
	public synchronized void setNome(String nome) {
		this.nome = nome;
	}
	public synchronized void setId(Long id) {
		this.id = id;
	}
	
}
