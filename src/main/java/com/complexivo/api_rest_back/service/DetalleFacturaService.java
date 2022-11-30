/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Detalle_Factura;
import java.util.List;

/**
 *
 * @author arons
 */

public interface DetalleFacturaService {
    
    public Detalle_Factura create (Detalle_Factura detalle_factura);

    public List<Detalle_Factura> getAll();

    public Detalle_Factura getById(long iddetalle);

    public Detalle_Factura updateEmpresa(long iddetalle, Detalle_Factura detalle_factura);

    public void deleteEmpresa(long iddetalle);
    
    public List<Detalle_Factura> getAllServicios();
    
    public List<Detalle_Factura> getAllProductos();
}
