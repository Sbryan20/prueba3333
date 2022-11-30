package com.complexivo.api_rest_back.modelo;


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
@Table(name = "rol", uniqueConstraints = {@UniqueConstraint(columnNames = "idrol")})
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idrol;

    @NotEmpty(message = "Nombre de rol no ingresado")
    @Size(min = 3, max = 20, message = "El rol debe contener entre 3 a 20 caracteres")
    private String rolnombre;

    @NotEmpty(message = "Descripcion de rol no ingresada")
    @Size(min = 10, max = 100, message = "La descripcion de contener entre 10 a 100 caracteres")
    private String descripcion;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="rol_id")
    private List<Usuario> usuario;
}
