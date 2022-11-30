
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(name = "servicio", uniqueConstraints = { @UniqueConstraint(columnNames = { "idservicio" }) })
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idservicio;
    
    @NotEmpty(message = "Nombre Servicio no ingresado")
    @Size(min = 2, max = 70, message = "El nombre de servicio debe tener mas de 2 caracteres")
    private String sernombre;
    
    @Max(value = 10000, message = "Número máximo de precio: 10000")
    @Min(value = 1, message = "Número mínimo de precio: 1")
    private int serprecio;
    
    @NotEmpty(message = "Descripcion no ingresado")
    @Size(min = 2, max = 70, message = "La descripcion de servicio debe tener mas de 2 caracteres")
    private String serdescripcion;
    
    @NotEmpty(message = "Duracion no ingresado")
    @Size(min = 2, max = 70, message = "La duracion de servicio debe tener mas de 2 caracteres")
    private String serduracion;
    
    @NotEmpty(message = "Imagen no ingresado")
    @Size(min = 2, message = "La url de imagen de servicio debe tener mas de 2 caracteres")
    private String serimagen;
    
    

    @ManyToOne
    @JoinColumn(name = "idempresa", nullable = false)
    private Empresa idempresa;

    @ManyToOne
    @JoinColumn(name="idcatser", nullable = false)
    private Categoria_Servicio idcatser;
    
    @ManyToOne
    @JoinColumn(name="idsubcat", nullable = false)
    private Subcategoria_Servicio idsubcat;
    
    @JsonIgnore
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="idservicio")
    private List<Detalle_Factura> detalle_Factura;
    
}
