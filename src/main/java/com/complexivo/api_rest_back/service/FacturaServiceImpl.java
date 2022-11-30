/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Factura;
import com.complexivo.api_rest_back.repository.FacturaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository repositorio;

    @Override
    public Factura createFactura(Factura factura) {
        return repositorio.save(factura);
    }

    @Override
    public List<Factura> getAllFactura() {
        return repositorio.findAll();
    }

    @Override
    public Factura getFacturaByID(long idfactura) {
        return repositorio.findById(idfactura).orElse(null);
    }

    @Override
    public Factura updateFactura(long idfactura, Factura factura) {
        Factura f = repositorio.findById(idfactura).orElseThrow(() -> new ResourceNotFoundException("factura", "id", idfactura));
        f.setUsu_id(factura.getUsu_id());
        f.setFecha_factura(factura.getFecha_factura());
        return repositorio.save(f);
    }

    @Override
    public void deleteFactura(long idfactura) {
        Factura fac = repositorio.findById(idfactura).orElseThrow(() -> new ResourceNotFoundException("factura", "id", idfactura));
        repositorio.delete(fac);
    }

}
