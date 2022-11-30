/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Subcategoria_Empresa;
import com.complexivo.api_rest_back.service.Subategoria_EmpresaService;
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
@RequestMapping("/api/subcategoriaempresa")
public class Subcategoria_EmpresaController {
    @Autowired
    private Subategoria_EmpresaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Subcategoria_Empresa>> listSubcategorias() {

        return new ResponseEntity<>(service.getAllSubcategoria(), HttpStatus.OK);
    }

    @GetMapping("/listar/{subcatnombre}")
    public ResponseEntity<Subcategoria_Empresa> getSubcategoriaByNombre(@PathVariable String subcatnombre) {

        return new ResponseEntity<>(service.getSubcategoriaByNombre(subcatnombre), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{idsubcatemp}")
    public ResponseEntity<Subcategoria_Empresa> getSubcategoriadById(@PathVariable Long idsubcatemp) {

        return new ResponseEntity<>(service.getSubcategoriadById(idsubcatemp), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Subcategoria_Empresa> saveSubcategoria(@Valid @RequestBody Subcategoria_Empresa subcategoria_Empresa) {

        return new ResponseEntity<>(service.createSubcategoria(subcategoria_Empresa), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idsubcatemp}")
    public ResponseEntity<Subcategoria_Empresa> editSubcategoria(@Valid @PathVariable long idsubcatemp, @Valid @RequestBody Subcategoria_Empresa subcategoria_Empresa) {

        Subcategoria_Empresa updatedSubcate = service.updateSubcategoria(idsubcatemp, subcategoria_Empresa);
        return new ResponseEntity<>(updatedSubcate, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idsubcatemp}")
    public ResponseEntity<Subcategoria_Empresa> deleteSubcategoria(@PathVariable long idsubcatemp) {

        service.deleteSubcategoria(idsubcatemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/listar/categoria/{idcatemp}")
        public ResponseEntity<List<Subcategoria_Empresa>> getByCategoria(@PathVariable long idcatemp) {

        return new ResponseEntity<>(service.getAllCategorias(idcatemp), HttpStatus.OK);
        }
}
        
