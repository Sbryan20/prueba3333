/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.AppException;
import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Persona;
import com.complexivo.api_rest_back.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Persona createPersona(Persona persona) {
        if (personaRepository.existsByCedula(persona.getCedula())) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "La cedula ingresada ya se encuentra en otro registro");
        }

        return personaRepository.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getPersonaById(long idpersona) {
        return personaRepository.findById(idpersona)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", idpersona));

    }

    @Override
    @Transactional(readOnly = true)
    public Persona getPersonaByCedula(String cedula) {
        Persona persona = personaRepository.findByCedula(cedula)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "cedula", cedula));

        return persona;
    }

    @Override
    @Transactional()
    public Persona updatePersona(long idpersona, Persona persona) {
        Persona p = personaRepository.findById(idpersona)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", idpersona));

        p.setCedula(persona.getCedula());
        p.setNombre(persona.getNombre());
        p.setApellido(persona.getApellido());
        p.setCelular(persona.getCelular());
        //p.setTelefono(persona.getTelefono());
        p.setCorreo(persona.getCorreo());
        p.setDireccion(persona.getDireccion());

        return personaRepository.save(p);
    }

    @Override
    @Transactional
    public void deletePersona(long idpersona) {
        Persona persona = personaRepository.findById(idpersona)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", idpersona));

        personaRepository.delete(persona);
    }

}
