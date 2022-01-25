package br.gen.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.gen.farmacia.model.Categoria;
import br.gen.farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	CategoriaRepository repository;
	
	//GET
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getAll(){
		List<Categoria> list = repository.findAll();
		
		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Lista Vazia!");
			
		} else {
			
			return ResponseEntity.status(200).body(list);
			
		}
		
	}
	
	@GetMapping("/id/{id_categoria}")
	public ResponseEntity<Categoria> getById(@PathVariable(value = "id_categoria") Long id){
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado!");
					
				});
	}
	
	//POST
	@PostMapping("/post")
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		
		return ResponseEntity.status(201).body(repository.save(categoria));
		
	}
	
	//PUT
	@PutMapping("/edit")
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
		
		return repository.findById(categoria.getId()).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseGet(() -> {
					
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!");
					
				});
		
	}
	
	
	
}
