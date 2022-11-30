/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Categoria_Servicio;
import com.complexivo.api_rest_back.service.Categoria_ServicioService;
import java.util.List;
import javax.validation.Valid;
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



/**
 *
 * @author Usuario
 */
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/categoriaservicio")
public class Categoria_ServicioController {
    @Autowired
    private Categoria_ServicioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria_Servicio>> listCategorias() {

        return new ResponseEntity<>(service.getAllCategoria(), HttpStatus.OK);
    }

    @GetMapping("/listar/{catnombre}")
    public ResponseEntity<Categoria_Servicio> getCategoriaByNombre(@PathVariable String catnombre) {

        return new ResponseEntity<>(service.getCategoriaByNombre(catnombre), HttpStatus.OK);
    }
    
  
    
    @GetMapping("/listar id/{idcatser}")
    public ResponseEntity<Categoria_Servicio> getCategoriadById(@PathVariable Long idcatser) {

        return new ResponseEntity<>(service.getCategoriadById(idcatser), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Categoria_Servicio> saveCategoria(@Valid @RequestBody Categoria_Servicio categoria_Servicio) {

        return new ResponseEntity<>(service.createCategoria(categoria_Servicio), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idcatser}")
    public ResponseEntity<Categoria_Servicio> editCategoria(@Valid @PathVariable long idcatser, @Valid @RequestBody Categoria_Servicio categoria_Servicio) {

        Categoria_Servicio updatedCate = service.updateCategoria(idcatser, categoria_Servicio);
        return new ResponseEntity<>(updatedCate, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idcatser}")
    public ResponseEntity<Categoria_Servicio> deleteCategoria(@PathVariable long idcatser) {

        service.deleteCategoria(idcatser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
