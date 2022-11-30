/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.repository;


import com.complexivo.api_rest_back.modelo.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public Optional<Persona> findByCedula(String cedula);
	
    public Boolean existsByCedula(String cedula);
}
