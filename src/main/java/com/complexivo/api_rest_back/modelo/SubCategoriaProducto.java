package com.complexivo.api_rest_back.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "subcategoriaproducto", uniqueConstraints = {@UniqueConstraint(columnNames = "subcatproid")})
public class SubCategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcatproid;

    @NotEmpty(message = "Nombre de subcategoria no ingresado")
    @Size(min = 3, max = 20, message = "La subcategoria debe contener entre 3 a 20 caracteres")
    private String subcatpronombre;
    
    @NotEmpty(message = "Descripción de Subcategoria no ingresado")
    @Size(min = 3, max = 100, message = "La descripción debe tener mas de 2 caracteres")
    private String subcatprodescripcion;
    
    @ManyToOne
    @JoinColumn(name="catproid",nullable = false)
    private CategoriaProducto catproid;
    
    @JsonIgnore
    @OneToMany(targetEntity = Producto.class, cascade = CascadeType.ALL)
    @JoinColumn(name="subcatproid",referencedColumnName="subcatproid")
    private List<Producto> catsubpro;
}
