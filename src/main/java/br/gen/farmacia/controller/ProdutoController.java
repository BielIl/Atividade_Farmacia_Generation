package br.gen.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.gen.farmacia.model.ProdutoModel;
import br.gen.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/farmaproduct")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	ProdutoRepository repository;
	
	//GET
	@GetMapping("/all")
	public ResponseEntity<List<ProdutoModel>> getAll(){
		List<ProdutoModel> list = repository.findAll();
		
		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Lista Vazia!");
			
		} else {
			
			return ResponseEntity.status(200).body(list);
			
		}
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable(value = "id_produto") Long id){
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseGet(() -> {
					
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado!");
					
				});
	}
	
	//POST
	@PostMapping("/post")
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel produto) {
		
		return ResponseEntity.status(201).body(repository.save(produto));
		
	}
	
	//PUT
	@PutMapping("/edit")
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel produto) {
		
		return repository.findById(produto.getId()).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseGet(() -> {
					
					throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!");
					
				});
		
	}
	
	//DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		java.util.Optional<ProdutoModel> optional = repository.findById(id);
		
			if (optional.isPresent()) {
				
				repository.deleteById(id);
				return ResponseEntity.status(200).build();
				
			} else {
				
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado!");
				
			}
			
	}
	

}
