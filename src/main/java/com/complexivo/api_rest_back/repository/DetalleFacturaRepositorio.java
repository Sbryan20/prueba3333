/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.repository;

import com.complexivo.api_rest_back.modelo.Detalle_Factura;
import com.complexivo.api_rest_back.modelo.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author arons
 */
public interface DetalleFacturaRepositorio extends JpaRepository<Detalle_Factura, Long> {
    
    @Query(value = "select * from railway.detalle where tipo='servicio' and idservicio > 1 ",nativeQuery=true)
    public List<Detalle_Factura> findByServicio();
    
    @Query(value = "select * from railway.detalle where tipo='producto' and idproducto > 1 ",nativeQuery=true)
    public List<Detalle_Factura> findByProducto();
    
}
