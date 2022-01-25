package br.gen.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
