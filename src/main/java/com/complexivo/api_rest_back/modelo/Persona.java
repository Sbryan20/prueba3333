/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Getter
@Setter
@Entity
@Table(name = "persona", uniqueConstraints = { @UniqueConstraint(columnNames = { "idpersona" }) })
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idpersona;

    @NotEmpty(message = "Cedula no ingresada")
    @Size(min = 10, max = 10, message = "La cedula debe tener 10 caracteres")
    private String cedula;

    @NotEmpty(message = "Nombre no ingresado")
    @Size(min = 2, max = 70, message = "El nombre debe tener mas de 2 caracteres")
    private String nombre;
    
    @NotEmpty(message = "Apellido no ingresado")
    @Size(min = 2, max = 70, message = "El apellido debe tener mas de 2 caracteres")
    private String apellido;
    
    @NotEmpty(message = "Celular no ingresado")
    @Size(min = 10, max = 10, message = "El celular debe tener 10 caracteres")
    private String celular;
    
    /*
        @NotEmpty(message = "Telefono no ingresado")
    @Size(min = 10, max = 10, message = "El telefono debe tener 10 caracteres")
    private String telefono;
    */

    
    @NotEmpty(message = "Correo no ingresado")
    @Size(min = 2, max = 70, message = "El correo debe tener mas de 2 caracteres")
    private String correo;
    
    @NotEmpty(message = "Direccion no ingresado")
    @Size(min = 2, max = 70, message = "La direccion debe tener mas de 2 caracteres")
    private String direccion;
    
    @JsonIgnore
    @OneToMany(targetEntity = Usuario.class,mappedBy = "persona")
    private List<Usuario> usuario;
 
}
