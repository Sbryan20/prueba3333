/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Subcategoria_Servicio;
import com.complexivo.api_rest_back.service.Subategoria_ServicioService;
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
@RequestMapping("/api/subcategoriaservicio")
public class Subcategoria_ServicioController {
    @Autowired
    private Subategoria_ServicioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Subcategoria_Servicio>> listSubcategorias() {

        return new ResponseEntity<>(service.getAllSubcategoria(), HttpStatus.OK);
    }

    @GetMapping("/listar/{subcatnombre}")
    public ResponseEntity<Subcategoria_Servicio> getSubcategoriaByNombre(@PathVariable String subcatnombre) {

        return new ResponseEntity<>(service.getSubcategoriaByNombre(subcatnombre), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{idsubcatser}")
    public ResponseEntity<Subcategoria_Servicio> getSubcategoriadById(@PathVariable Long idsubcatser) {

        return new ResponseEntity<>(service.getSubcategoriadById(idsubcatser), HttpStatus.OK);
    }
    
    @GetMapping("/listar/categoria/{idcatser}")
    public ResponseEntity<List<Subcategoria_Servicio>> getServicioByCategoria(@PathVariable long idcatser) {

        return new ResponseEntity<>(service.getAllCategorias(idcatser), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Subcategoria_Servicio> saveSubcategoria(@Valid @RequestBody Subcategoria_Servicio subcategoria_Servicio) {

        return new ResponseEntity<>(service.createSubcategoria(subcategoria_Servicio), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{idsubcatser}")
    public ResponseEntity<Subcategoria_Servicio> editSubcategoria(@Valid @PathVariable long idsubcatser, @Valid @RequestBody Subcategoria_Servicio subcategoria_Servicio) {

        Subcategoria_Servicio updatedSubcate = service.updateSubcategoria(idsubcatser, subcategoria_Servicio);
        return new ResponseEntity<>(updatedSubcate, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idsubcatser}")
    public ResponseEntity<Subcategoria_Servicio> deleteSubcategoria(@PathVariable long idsubcatser) {

        service.deleteSubcategoria(idsubcatser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
