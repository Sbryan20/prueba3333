/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;

import java.util.ArrayList;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author arons
 */
@Getter
@Setter
@Entity
@Table(name = "detalle", uniqueConstraints = { @UniqueConstraint(columnNames = { "iddetalle" }) })
public class Detalle_Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddetalle;
    
    @NotNull(message = "Cantidad no ingresada")
    private int cantidad;
    
    @NotNull(message = "Precio no ingresada")
    private Double precio;
    
    @NotNull(message = "Tipo no ingresado")
    private String tipo;

    @ManyToOne
    @JoinColumn(name="idproducto")
    private Producto idproducto;
    
    @ManyToOne
    @JoinColumn(name="idfactura",nullable = false)
    private Factura idfactura;
    
    @ManyToOne
    @JoinColumn(name="idservicio")
    private Servicio idservicio;
    
    
    
    

    

}
