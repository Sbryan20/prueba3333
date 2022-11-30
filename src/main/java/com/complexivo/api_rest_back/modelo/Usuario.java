/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "usu_id" }) })
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usu_id;
    
    @NotEmpty(message = "Usuario no ingresado")
    @Size(min = 2, max = 15, message = "El usuario debe tener mas de 2 caracteres")
    private String usuusuario;
    
    @NotEmpty(message = "Contrase�a no ingresada")
    @Size(min = 6, max = 15, message = "La contrase�a debe tener mas de 6 caracteres")
    private String usu_contrasena;
    
    @ManyToOne
    @JoinColumn(name="rol_id",nullable = false)
    private Rol rol_id;
    
    @ManyToOne
    @JoinColumn(name="per_id", nullable = false)
    private Persona persona;
    ///////
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="usu_id")
    private List<Solicitud> solicitudes;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="usu_id")
    private List<Empresa> empresas;
       
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="usu_id")
    private List<Factura> factura;
    
}
