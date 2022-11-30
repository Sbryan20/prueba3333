/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Factura;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */

public interface FacturaService {

    public Factura createFactura(Factura factura);

    public List<Factura> getAllFactura();

    public Factura getFacturaByID(long idfactura);

    public Factura updateFactura(long idfactura, Factura factura);

    public void deleteFactura(long idfactura);
}
