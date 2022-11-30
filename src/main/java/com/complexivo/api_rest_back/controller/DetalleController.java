/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Detalle_Factura;
import com.complexivo.api_rest_back.service.DetalleFacturaService;
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
 * @author arons
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

    @Autowired
    private DetalleFacturaService servicio;

    @GetMapping("/listar")
    public ResponseEntity<List<Detalle_Factura>> listFactura() {

        return new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
    }

    @GetMapping("/listar/servicios")
    public ResponseEntity<List<Detalle_Factura>> listServicios() {

        return new ResponseEntity<>(servicio.getAllServicios(), HttpStatus.OK);
    }

    @GetMapping("/listar/productos")
    public ResponseEntity<List<Detalle_Factura>> listProductos() {

        return new ResponseEntity<>(servicio.getAllProductos(), HttpStatus.OK);
    }

    @GetMapping("/listar id/{iddetalle}")
    public ResponseEntity<Detalle_Factura> getById(@PathVariable Long iddetalle) {

        return new ResponseEntity<>(servicio.getById(iddetalle), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Detalle_Factura> saveDetalle(@Valid @RequestBody Detalle_Factura factura) {

        return new ResponseEntity<>(servicio.create(factura), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{iddetalle}")
    public ResponseEntity<Detalle_Factura> saveDetalle(@Valid @PathVariable long iddetalle, @Valid @RequestBody Detalle_Factura factura) {
        Detalle_Factura updateFactura = servicio.updateEmpresa(iddetalle, factura);
        return new ResponseEntity<>(updateFactura, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{iddetalle}")
    public ResponseEntity<Detalle_Factura> deleteDetalle(@PathVariable long iddetalle) {
        servicio.deleteEmpresa(iddetalle);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
