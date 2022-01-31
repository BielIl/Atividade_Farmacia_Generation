package br.gen.farmacia.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * @version v2 (Desenvolvimento Model Categoria: atributos, anotações e getters/setters)
 * @since 29-01-2022
 * @author Grupo 2 Turma 42 - Generation Brasil
 */

@Entity
@Table (name = "tbCategoria")
public class Categoria {

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String setor;
		
	private String requerimento;

	@NotNull
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(String requerimento) {
		this.requerimento = requerimento;
	}
	
}