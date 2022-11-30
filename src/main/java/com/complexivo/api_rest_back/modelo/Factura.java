/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author arons
 */
@Getter
@Setter
@Entity
@Table(name = "factura", uniqueConstraints = { @UniqueConstraint(columnNames = { "idfactura" }) })
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfactura;
    
    
    
    
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @NotNull(message="Debe ingresar la fecha")
    private LocalDate fecha_factura;
    
    @ManyToOne
    @JoinColumn(name="usu_id",nullable = false)
    private Usuario usu_id ;
    
    ////////
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idfactura")
    private List<Detalle_Factura> detallefactura;
    
}
