	package br.gen.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "tbCategoria")
public class Categoria {

	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String setor;
	
	private String requerimento;

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