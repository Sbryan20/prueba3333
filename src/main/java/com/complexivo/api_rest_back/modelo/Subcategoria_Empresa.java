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
@Table(name = "subcategoria_empresa", uniqueConstraints = { @UniqueConstraint(columnNames = { "idsubcatemp" }) })
public class Subcategoria_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsubcatemp;
    
    @NotEmpty(message = "Nombre de Subcategoria no ingresado")
    @Size(min = 2, max = 70, message = "El nombre debe tener mas de 2 caracteres")
    private String subcatnombre;
    
    @NotEmpty(message = "Descripción de Subcategoria no ingresado")
    @Size(min = 3, max = 100, message = "La descripción debe tener mas de 2 caracteres")
    private String subcatdescripcion;
   
    @ManyToOne
    @JoinColumn(name="idcatemp",nullable = false)
    private Categoria_Empresa  idcatemp;
    
    @JsonIgnore
    @OneToMany(targetEntity = Cat_sub_emp.class, cascade = CascadeType.ALL)
    @JoinColumn(name="idsubcatemp",referencedColumnName="idsubcatemp")
    private List<Cat_sub_emp> cat_sub_emp;
    
}
