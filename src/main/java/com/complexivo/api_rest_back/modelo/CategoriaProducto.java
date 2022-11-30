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
@Table(name = "categoriaproducto", uniqueConstraints = {@UniqueConstraint(columnNames = "catproid")})
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long catproid;

    @NotEmpty(message = "Nombre de categoria no ingresado")
    @Size(min = 3, max = 20, message = "La categoria debe contener entre 3 a 20 caracteres")
    private String catpronombre;
    
    @NotEmpty(message = "Descripción de Categoria no ingresado")
    @Size(min = 3, max = 100, message = "La descripción debe tener mas de 2 caracteres")
    private String catprodescripcion;
    
    @JsonIgnore
    @OneToMany(targetEntity = SubCategoriaProducto.class, cascade = CascadeType.ALL)
    @JoinColumn(name="catproid",referencedColumnName="catproid")
    private List<SubCategoriaProducto> subcategoriaproducto;
    
    @JsonIgnore
    @OneToMany(targetEntity = Producto.class, cascade = CascadeType.ALL)
    @JoinColumn(name="catproid",referencedColumnName="catproid")
    private List<Producto> producto;
    
    
   
}
