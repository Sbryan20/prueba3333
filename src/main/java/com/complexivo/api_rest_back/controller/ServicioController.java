/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Categoria_Servicio;
import com.complexivo.api_rest_back.modelo.Servicio;
import com.complexivo.api_rest_back.repository.Categoria_ServicioRepository;
import com.complexivo.api_rest_back.service.ServicioService;
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
@RequestMapping("/api/servicio")
public class ServicioController {
    @Autowired
    private ServicioService Service;
    
    @Autowired 
    private Categoria_ServicioRepository categoriaRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listServicios() {

       
        
        return new ResponseEntity<>(Service.getAllServicio(), HttpStatus.OK);
    }

    @GetMapping("/listar/{sernombre}")
    public ResponseEntity<Servicio> getServicioBySernombre(@PathVariable String sernombre) {

        return new ResponseEntity<>(Service.getServicioBySernombre(sernombre), HttpStatus.OK);
    }
    
    @GetMapping("/listar/categoria/{idcatser}")
    public ResponseEntity<List<Servicio>> getServicioByCategoria(@PathVariable long idcatser) {

        return new ResponseEntity<>(Service.getAllCategorias(idcatser), HttpStatus.OK);
    }
    
    @GetMapping("/listar/subcategoria/{idsubcat}")
    public ResponseEntity<List<Servicio>> getServicioBySubcategoria(@PathVariable long idsubcat) {

        return new ResponseEntity<>(Service.getAllSubcategorias(idsubcat), HttpStatus.OK);
    }
    
    @GetMapping("/listar id/{idservicio}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable Long idservicio) {

        return new ResponseEntity<>(Service.getServicioById(idservicio), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Servicio> saveService(@Valid @RequestBody Servicio servicio) {

        
        
        return new ResponseEntity<>(Service.createServicio(servicio), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idservicio}")
    public ResponseEntity<Servicio> editService(@Valid @PathVariable long idservicio, @Valid @RequestBody Servicio servicio) {

        Servicio updatedSer = Service.updateServicio(idservicio, servicio);
        return new ResponseEntity<>(updatedSer, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idservicio}")
    public ResponseEntity<Servicio> deleteService(@PathVariable long idservicio) {

        Service.deleteServicio(idservicio);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/listar/empresa/{idempresa}")
    public ResponseEntity<List<Servicio>> getServicioByIdempresa(@PathVariable long idempresa) {

        return new ResponseEntity<>(Service.getIdempresa(idempresa), HttpStatus.OK);
    }
    
    @GetMapping("/listar/servicios/{idempresa}")
    public ResponseEntity<List<Object>> getServicios(@PathVariable Long idempresa) {
        return new ResponseEntity<>(Service.getServicios(idempresa), HttpStatus.OK);
    }
}
