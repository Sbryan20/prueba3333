
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.CategoriaProducto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.complexivo.api_rest_back.service.CategoriaProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/categoriaproducto")
public class CategoriaProductoController {
    @Autowired
    private CategoriaProductoService categoriaProductoService;

	@GetMapping("/listar")
	public ResponseEntity<List<CategoriaProducto>> listCategoriaProducto() {

		return new ResponseEntity<>(categoriaProductoService.getAllCategoriaProducto(), HttpStatus.OK);
	}

	@GetMapping("/listar/{catpronombre}")
	public ResponseEntity<CategoriaProducto> getCategoriaProductoByCatpronombre(@PathVariable String catpronombre){
		
		return new ResponseEntity<>(categoriaProductoService.getCategoriaProductoByCatpronombre(catpronombre), HttpStatus.OK);
	}
	
        @GetMapping("/listar id/{catproid}")
	public ResponseEntity<CategoriaProducto> getCategoriaProductoById(@PathVariable Long catproid){
		
		return new ResponseEntity<>(categoriaProductoService.getCategoriaProductoById(catproid), HttpStatus.OK);
	}
        
	@PostMapping("/crear")
	public ResponseEntity<CategoriaProducto> saveCategoriaProducto(@Valid @RequestBody CategoriaProducto categoriaproducto) {

		return new ResponseEntity<>(categoriaProductoService.createCategoriaProducto(categoriaproducto), HttpStatus.CREATED);

	}
	
	@PutMapping("/editar/{catproid}")
	public ResponseEntity<CategoriaProducto> updateCategoriaProducto(@Valid @PathVariable long catproid,@Valid  @RequestBody CategoriaProducto categoriaproducto) {

		CategoriaProducto updatedCategoriaProducto = categoriaProductoService.updateCategoriaProducto(catproid, categoriaproducto);
		return new ResponseEntity<>(updatedCategoriaProducto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{catproid}")
	public ResponseEntity<CategoriaProducto> deleteCategoriaProducto(@PathVariable long catproid) {

		categoriaProductoService.deleteCategoriaProducto(catproid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
