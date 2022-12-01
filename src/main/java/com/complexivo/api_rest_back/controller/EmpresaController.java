/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Empresa;
import com.complexivo.api_rest_back.service.EmpresaService;
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
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Empresa>> listEmpresas() {

        return new ResponseEntity<>(empresaService.getAllEmpresa(), HttpStatus.OK);
    }

    @GetMapping("/listar/{empnombre}")
    public ResponseEntity<Empresa> getEmpresaByEmpnombre(@PathVariable String empnombre) {

        return new ResponseEntity<>(empresaService.getEmpresaByEmpnombre(empnombre), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{idempresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long idempresa) {

        return new ResponseEntity<>(empresaService.getEmpresaById(idempresa), HttpStatus.OK);
    }
    
    @GetMapping("/listar/reporte/{idempresa}")
    public ResponseEntity<List<Empresa>> geEmpresaReporte(@PathVariable long idempresa) {

        return new ResponseEntity<>(empresaService.getAllReporte(idempresa), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Empresa> saveEmpresa(@Valid @RequestBody Empresa empresa) {

        return new ResponseEntity<>(empresaService.createEmpresa(empresa), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idempresa}")
    public ResponseEntity<Empresa> editEmpresa(@Valid @PathVariable long idempresa, @Valid @RequestBody Empresa empresa) {

        Empresa updatedEmpre = empresaService.updateEmpresa(idempresa, empresa);
        return new ResponseEntity<>(updatedEmpre, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idempresa}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable long idempresa) {

        empresaService.deleteEmpresa(idempresa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/listar/ranking/{idempresa}")
    public ResponseEntity<List<Object>> getRanking() {
        return new ResponseEntity<>(empresaService.getRanking(), HttpStatus.OK);
    }
    
    @GetMapping("/listar/FechaVenta/{idempresa}")
    public ResponseEntity<List<Object>> getRanking(Long idempresa, int mes, int año) {
        return new ResponseEntity<>(empresaService.getFechaEmpresa(idempresa,mes,año), HttpStatus.OK);
    }
}
