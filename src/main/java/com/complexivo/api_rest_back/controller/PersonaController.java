/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Persona;
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
 * @author Usuario
 */
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> listPersonas() {

		return new ResponseEntity<>(personaService.getAllPersona(), HttpStatus.OK);
	}

	@GetMapping("/listar/{cedula}")
	public ResponseEntity<Persona> getPersonaByDNI(@PathVariable String cedula){
		
		return new ResponseEntity<>(personaService.getPersonaByCedula(cedula), HttpStatus.OK);
	}
        
        @GetMapping("/listar id/{idpersona}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable Long idpersona){
		
		return new ResponseEntity<>(personaService.getPersonaById(idpersona), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Persona> savePersona(@Valid @RequestBody Persona persona) {

		return new ResponseEntity<>(personaService.createPersona(persona), HttpStatus.CREATED);

	}
	
	@PutMapping("/editar/{idpersona}")
	public ResponseEntity<Persona> savePersona(@Valid @PathVariable long idpersona,@Valid  @RequestBody Persona persona) {

		Persona updatedPerson = personaService.updatePersona(idpersona, persona);
		return new ResponseEntity<>(updatedPerson, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/eliminar/{idpersona}")
	public ResponseEntity<Persona> deletePersona(@PathVariable long idpersona) {

		personaService.deletePersona(idpersona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
