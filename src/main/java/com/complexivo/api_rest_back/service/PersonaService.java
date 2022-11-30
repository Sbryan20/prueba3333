/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Persona;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PersonaService {
    
    public Persona createPersona(Persona persona);

    public List<Persona> getAllPersona();

    public Persona getPersonaById(long idpersona);

    public Persona getPersonaByCedula(String cedula);

    public Persona updatePersona(long idpersona, Persona persona);

    public void deletePersona(long idpersona);
}
