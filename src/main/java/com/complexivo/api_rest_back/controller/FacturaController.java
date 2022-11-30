/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Factura;
import com.complexivo.api_rest_back.modelo.Persona;
import com.complexivo.api_rest_back.service.FacturaService;
import com.complexivo.api_rest_back.service.PersonaService;
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
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/factura")
public class FacturaController {
    
    @Autowired
    private FacturaService servicio;

	@GetMapping("/listar")
	public ResponseEntity<List<Factura>> list() {
		return new ResponseEntity<>(servicio.getAllFactura(), HttpStatus.OK);
	}

	@GetMapping("/listar id/{idfactura}")
	public ResponseEntity<Factura> getPersonaByDNI(@PathVariable Long idfactura){
		
		return new ResponseEntity<>(servicio.getFacturaByID(idfactura), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Factura> savePersona(@Valid @RequestBody Factura factura) {

		return new ResponseEntity<>(servicio.createFactura(factura), HttpStatus.CREATED);

	}
	
	@PutMapping("/editar/{idfactura}")
	public ResponseEntity<Factura> save(@Valid @PathVariable long idfactura,@Valid  @RequestBody Factura factura) {
		Factura updateFactura = servicio.updateFactura(idfactura, factura);
		return new ResponseEntity<>(updateFactura, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{idfactura}")
	public ResponseEntity<Factura> delete(@PathVariable long idfactura) {
		servicio.deleteFactura(idfactura);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
