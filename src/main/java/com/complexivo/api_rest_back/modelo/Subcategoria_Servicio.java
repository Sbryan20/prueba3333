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

/**
 *
 * @author Usuario
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subcategoria_servicio", uniqueConstraints = { @UniqueConstraint(columnNames = { "idsubcat" }) })
public class Subcategoria_Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsubcat;
    
    @NotEmpty(message = "Nombre de Subcategoria no ingresado")
    @Size(min = 2, max = 70, message = "El nombre debe tener mas de 2 caracteres")
    private String subcatnombre;
    
    @NotEmpty(message = "Detalle Servicio no ingresado")
    @Size(min = 2, max = 70, message = "El detalle Servicio debe tener mas de 2 caracteres")
    private String subcatdetalle;
    
    @ManyToOne
    @JoinColumn(name="idcatser",nullable = false)
    private Categoria_Servicio idcatser;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idsubcat")
    private List<Servicio> servicios;
}
