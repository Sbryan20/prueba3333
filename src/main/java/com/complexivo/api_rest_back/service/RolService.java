/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Persona;
import com.complexivo.api_rest_back.modelo.Rol;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
public interface RolService {
    
    public Rol createRol(Rol rolnombre);

    public List<Rol> getAllRol();

    public Rol getRolById(long idrol);

    public Rol getRolfindByRolnomobre(String rolnombre);

    public Rol updateRol(long idrol, Rol rolnombre);

    public void deleteById(long idrol);
}
