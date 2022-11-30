/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cat_sub_emp", uniqueConstraints = { @UniqueConstraint(columnNames = { "iddetalle" }) })
public class Cat_sub_emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iddetalle;
    
    @NotEmpty(message = "Detalle no ingresado")
    @Size(min = 2, max = 70, message = "El detalle debe tener mas de 2 caracteres")
    private String csedetalle;
    
    @ManyToOne
    @JoinColumn(name="idempresa",nullable = false)
    private Empresa idempresa;
    
    @ManyToOne
    @JoinColumn(name="idcatemp",nullable = false)
    private Categoria_Empresa idcatemp;
    
    @ManyToOne
    @JoinColumn(name="idsubcatemp",nullable = false)
    private Subcategoria_Empresa idsubcatemp;
 
}
