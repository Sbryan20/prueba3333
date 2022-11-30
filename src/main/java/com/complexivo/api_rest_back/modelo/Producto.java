/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Usuario
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto", uniqueConstraints = { @UniqueConstraint(columnNames = { "idproducto" }) })
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproducto;

    @NotEmpty(message = "Nombre no ingresado")
    @Size(min = 2, max = 70, message = "El nombre debe tener mas de 2 caracteres")
    private String nombre;  
  
       
    private int  precio;
    
    private int  stock;
    
    private int num_lote;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_vencimiento")
    private Date fecha_vencimiento;
    
    @NotEmpty(message = "Descripción no ingresado")
    @Size(min = 3, max = 100, message = "La descripción debe tener mas de 3 caracteres")
    private String descripcion;
    
    @NotEmpty(message = "Imagen no ingresado")
    private String imagen;
    
  
    
    @ManyToOne
    @JoinColumn(name = "idempresa", nullable = false)
    private Empresa idempresa;
    
    //////
    
    @ManyToOne
    @JoinColumn(name="catproid",nullable = false)
    private CategoriaProducto catproid;
    
    @ManyToOne
    @JoinColumn(name="subcatproid",nullable = false)
    private SubCategoriaProducto subcatproid;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idproducto")
    private List<Detalle_Factura> detallefactura;
}
