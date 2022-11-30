/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
@Table(name = "empresa", uniqueConstraints = { @UniqueConstraint(columnNames = { "idempresa" }) })
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idempresa;
    
    @NotEmpty(message = "Ruc no ingresado")
    @Size(min = 13, max = 13, message = "El ruc debe tener 13 caracteres")
    //@Pattern(regexp="[0-9]{12} [001]")
    private String empruc;
    
    @NotEmpty(message = "Nombre Comercial no ingresado")
    @Size(min = 2, max = 70, message = "El nombre comercial debe tener mas de 2 caracteres")
    private String empnombre;
    
    @NotEmpty(message = "Representante legal no ingresado")
    @Size(min = 2, max = 70, message = "El representante legal debe tener mas de 2 caracteres")
    private String emprepresentante;
    
    @NotEmpty(message = "Razón Social no ingresado")
    @Size(min = 2, max = 70, message = "La Razón Social debe tener mas de 2 caracteres")
    private String emprazon;
    
    @NotEmpty(message = "Télefono no ingresado")
    @Size(min = 10, max = 10, message = "El télefono debe tener 10 caracteres")
    private String emptelefono;
    
    @NotEmpty(message = "Correo no ingresado")
    @Size(min = 2, max = 70, message = "El correo debe tener mas de 2 caracteres")
    private String empcorreo;
    
    @NotEmpty(message = "Dirección no ingresado")
    @Size(min = 2, max = 70, message = "La dirección debe tener mas de 2 caracteres")
    private String empdireccion;
    
    @NotEmpty(message = "Numero de Trabajadores no ingresado")
    @Size(min = 1, max = 70, message = "El numero de trabajadores tener mas de 1 caracteres")
    private String empnumtrabajadores;
    
    @NotEmpty(message = "Ciudad no ingresado")
    @Size(min = 2, max = 70, message = "La ciudad debe tener mas de 2 caracteres")
    private String empciudad;
    
    @Max(value = 10000, message = "Número máximo de ingreso anual: 10000")
    @Min(value = 10, message = "Número mínimo de ingreso anual: 10")
    private int empingresoanual;
     
    @NotEmpty(message = "Observaciones no ingresadas")
    @Size(min = 2, max = 70, message = "Las observaciones debe tener mas de 2 caracteres")
    private String empobservaciones; 
    
    @Temporal(TemporalType.DATE)
    @Column(name="empfecha")
    private Date empfecha;
    
    @NotEmpty(message = "Estado no ingresado")
    @Size(min = 2, max = 70, message = "El estado debe tener mas de 2 caracteres")
    private String empestado;
    
    @ManyToOne
    @JoinColumn(name="usu_id", nullable = false)
    private Usuario usu_id;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idempresa")
    private List<Solicitud> solicitudes;
    
    @JsonIgnore
    @OneToMany(targetEntity = Cat_sub_emp.class, cascade = CascadeType.ALL)
    @JoinColumn(name="idempresa",referencedColumnName="idempresa")
    private List<Cat_sub_emp> Cat_sub_emp;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idempresa")
    private List<Producto> producto;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idempresa")
    private List<Servicio> servicio;
    
    
    
}
