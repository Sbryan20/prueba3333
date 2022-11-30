
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.CategoriaProducto;
import com.complexivo.api_rest_back.modelo.Producto;
import com.complexivo.api_rest_back.service.CategoriaProductoService;
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
import com.complexivo.api_rest_back.service.ProductoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/prodcuto")
public class ProductoController {
    @Autowired
    private ProductoService prodcutoService;
    
    private CategoriaProductoService categoriaProductoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listProducto() {

		return new ResponseEntity<>(prodcutoService.getAllProducto(), HttpStatus.OK);
	}

	@GetMapping("/listar/{nombre}")
	public ResponseEntity<Producto> getProductoByProducto(@PathVariable String nombre){
		
		return new ResponseEntity<>(prodcutoService.getProductoByProducto(nombre), HttpStatus.OK);
	}
	
        @GetMapping("/listar id/{idproducto}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long idproducto){
		
		return new ResponseEntity<>(prodcutoService.getProductoById(idproducto), HttpStatus.OK);
	}
        
	@PostMapping("/crear")
	public ResponseEntity<Producto> saveProducto(@Valid @RequestBody Producto prodcuto) {

		return new ResponseEntity<>(prodcutoService.createProducto(prodcuto), HttpStatus.CREATED);

	}
	
	@PutMapping("/editar/{idproducto}")
	public ResponseEntity<Producto> updateProducto(@Valid @PathVariable long idproducto,@Valid  @RequestBody Producto prodcuto) {

		Producto updatedProducto = prodcutoService.updateProducto(idproducto, prodcuto);
		return new ResponseEntity<>(updatedProducto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{idproducto}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable long idproducto) {

		prodcutoService.deleteProducto(idproducto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
        
        @GetMapping("/listar/nuevo")
	public ResponseEntity<String> listProductoNuevo(Model modelo) {
            List<CategoriaProducto> listaCategoria = categoriaProductoService.getAllCategoriaProducto();
            modelo.addAttribute("producto",new Producto());
            modelo.addAttribute("listaCategoria",listaCategoria);
//		return new ResponseEntity<>("",categoriaProductoService.getAllCategoriaProducto(), HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
	}
        
        @GetMapping("/listar/categoria/{catproid}")
    public ResponseEntity<List<Producto>> getProductoByCategoria(@PathVariable long catproid) {

        return new ResponseEntity<>(prodcutoService.getAllCategorias(catproid), HttpStatus.OK);
    }
    
    @GetMapping("/listar/subcategoria/{subcatproid}")
    public ResponseEntity<List<Producto>> getProductoBySubcategoria(@PathVariable long subcatproid) {

        return new ResponseEntity<>(prodcutoService.getAllSubcategorias(subcatproid), HttpStatus.OK);
    }
    
    @GetMapping("/listar/productosventa/{idempresa}")
    public ResponseEntity<List<Object>> getProductos(@PathVariable Long idempresa) {
        return new ResponseEntity<>(prodcutoService.getProductos(idempresa), HttpStatus.OK);
    }
    
    @GetMapping("/listar/empresa/{idempresa}")
    public ResponseEntity<List<Producto>> getProductoByIdempresa(@PathVariable long idempresa) {

        return new ResponseEntity<>(prodcutoService.getIdempresa(idempresa), HttpStatus.OK);
    }
}
