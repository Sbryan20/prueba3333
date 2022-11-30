
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.SubCategoriaProducto;
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
import com.complexivo.api_rest_back.service.SubCategoriaProductoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/subcategoriaproducto")
public class SubCategoriaProductoController {
    @Autowired
    private SubCategoriaProductoService subcategoriaProductoService;

	@GetMapping("/listar")
	public ResponseEntity<List<SubCategoriaProducto>> listSubCategoriaProducto() {

		return new ResponseEntity<>(subcategoriaProductoService.getAllSubCategoriaProducto(), HttpStatus.OK);
	}

	@GetMapping("/listar/{subcatpronombre}")
	public ResponseEntity<SubCategoriaProducto> getSubCategoriaProductoByCatpronombre(@PathVariable String subcatpronombre){
		
		return new ResponseEntity<>(subcategoriaProductoService.getSubCategoriaProductoByCatpronombre(subcatpronombre), HttpStatus.OK);
	}
	
        @GetMapping("/listar id/{subcatproid}")
	public ResponseEntity<SubCategoriaProducto> getSubCategoriaProductoById(@PathVariable Long subcatproid){
		
		return new ResponseEntity<>(subcategoriaProductoService.getSubCategoriaProductoById(subcatproid), HttpStatus.OK);
	}
        
        
        
	@PostMapping("/crear")
	public ResponseEntity<SubCategoriaProducto> saveSubCategoriaProducto(@Valid @RequestBody SubCategoriaProducto subcategoriaproducto) {

		return new ResponseEntity<>(subcategoriaProductoService.createSubCategoriaProducto(subcategoriaproducto), HttpStatus.CREATED);

	}
	
	@PutMapping("/editar/{subcatproid}")
	public ResponseEntity<SubCategoriaProducto> updateSubCategoriaProducto(@Valid @PathVariable long subcatproid,@Valid  @RequestBody SubCategoriaProducto subcategoriaproducto) {

		SubCategoriaProducto updatedSubCategoriaProducto = subcategoriaProductoService.updateSubCategoriaProducto(subcatproid, subcategoriaproducto);
		return new ResponseEntity<>(updatedSubCategoriaProducto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{subcatproid}")
	public ResponseEntity<SubCategoriaProducto> deleteSubCategoriaProducto(@PathVariable long subcatproid) {

		subcategoriaProductoService.deleteSubCategoriaProducto(subcatproid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
        
        @GetMapping("/listar/categoria/{catproid}")
        public ResponseEntity<List<SubCategoriaProducto>> getProductoByCategoria(@PathVariable long catproid) {

        return new ResponseEntity<>(subcategoriaProductoService.getAllCategorias(catproid), HttpStatus.OK);
    }
}
