/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Cat_sub_emp;
import com.complexivo.api_rest_back.service.Cat_sub_empService;
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
@RequestMapping("/api/cat-sub-emp")
public class Cat_sub_empController {
    @Autowired
    private Cat_sub_empService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Cat_sub_emp>> listDetalle() {

        return new ResponseEntity<>(service.getAllDetalle(), HttpStatus.OK);
    }

    @GetMapping("/listar/{csedetalle}")
    public ResponseEntity<Cat_sub_emp> getDetalleByDet(@PathVariable String csedetalle) {

        return new ResponseEntity<>(service.getDetalleByDet(csedetalle), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{iddetalle}")
    public ResponseEntity<Cat_sub_emp> getDetalleById(@PathVariable Long iddetalle) {

        return new ResponseEntity<>(service.getDetalleById(iddetalle), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Cat_sub_emp> saveEmpresa(@Valid @RequestBody Cat_sub_emp cat_sub_emp) {

        return new ResponseEntity<>(service.createDetalle(cat_sub_emp), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{iddetalle}")
    public ResponseEntity<Cat_sub_emp> editDetalle(@Valid @PathVariable long iddetalle, @Valid @RequestBody Cat_sub_emp cat_sub_emp) {

        Cat_sub_emp updateddet = service.updateDetalle(iddetalle, cat_sub_emp);
        return new ResponseEntity<>(updateddet, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{iddetalle}")
    public ResponseEntity<Cat_sub_emp> deleteDetalle(@PathVariable long iddetalle) {

        service.deleteDetalle(iddetalle);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/listar/empresa/{idempresa}")
    public ResponseEntity<List<Cat_sub_emp>> getCatSubEmpByIdempresa(@PathVariable long idempresa) {

        return new ResponseEntity<>(service.getIdempresa(idempresa), HttpStatus.OK);
    }
}
