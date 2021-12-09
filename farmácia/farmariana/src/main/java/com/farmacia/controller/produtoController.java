package com.farmacia.controller;

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
import com.farmacia.model.produto;
import com.farmacia.repository.produtoRepository;

	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/produto")

	public class produtoController {

		@Autowired
		private produtoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<produto>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<produto> getById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nomeProduto/{nomeProduto}")
		public ResponseEntity<List<produto>> getByNomeProduto(@PathVariable String nomeProduto){
			return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
		}
		
		@PostMapping
		public ResponseEntity<produto> post (@RequestBody produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		@PutMapping
		public ResponseEntity<produto> put (@RequestBody produto produto){
			return ResponseEntity.ok(repository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}

}
