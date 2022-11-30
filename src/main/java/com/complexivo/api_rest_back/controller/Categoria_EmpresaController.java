/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Categoria_Empresa;
import com.complexivo.api_rest_back.service.Categoria_EmpresaService;
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
@RequestMapping("/api/categoriaempresa")
public class Categoria_EmpresaController {
    @Autowired
    private Categoria_EmpresaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Categoria_Empresa>> listCategorias() {

        return new ResponseEntity<>(service.getAllCategoria(), HttpStatus.OK);
    }

    @GetMapping("/listar/{catnombre}")
    public ResponseEntity<Categoria_Empresa> getCategoriaByNombre(@PathVariable String catnombre) {

        return new ResponseEntity<>(service.getCategoriaByNombre(catnombre), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{idcatemp}")
    public ResponseEntity<Categoria_Empresa> getCategoriadById(@PathVariable Long idcatemp) {

        return new ResponseEntity<>(service.getCategoriadById(idcatemp), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Categoria_Empresa> saveCategoria(@Valid @RequestBody Categoria_Empresa categoria_Empresa) {

        return new ResponseEntity<>(service.createCategoria(categoria_Empresa), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idcatemp}")
    public ResponseEntity<Categoria_Empresa> editCategoria(@Valid @PathVariable long idcatemp, @Valid @RequestBody Categoria_Empresa categoria_Empresa) {

        Categoria_Empresa updatedCate = service.updateCategoria(idcatemp, categoria_Empresa);
        return new ResponseEntity<>(updatedCate, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idcatemp}")
    public ResponseEntity<Categoria_Empresa> deleteCategoria(@PathVariable long idcatemp) {

        service.deleteCategoria(idcatemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
