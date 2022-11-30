/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Detalle_Factura;
import com.complexivo.api_rest_back.repository.DetalleFacturaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arons
 */
@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService{

    @Autowired
    private DetalleFacturaRepositorio repositorio;
    
    @Override
    public Detalle_Factura create(Detalle_Factura detalle_factura) {
        return repositorio.save(detalle_factura);
    }

    @Override
    public List<Detalle_Factura> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Detalle_Factura getById(long iddetalle) {
        return repositorio.findById(iddetalle).orElse(null);
    }

    @Override
    public Detalle_Factura updateEmpresa(long iddetalle, Detalle_Factura detalle_factura) {
        Detalle_Factura d = repositorio.findById(iddetalle).orElseThrow(() -> new ResourceNotFoundException("detalleFactura", "id", iddetalle));
        d.setIdproducto(detalle_factura.getIdproducto());
        d.setIdfactura(detalle_factura.getIdfactura());
        d.setCantidad(detalle_factura.getCantidad());
        d.setPrecio(detalle_factura.getPrecio());
        
        return repositorio.save(d);
    }

    @Override
    public void deleteEmpresa(long iddetalle) {
          Detalle_Factura dta = repositorio.findById(iddetalle).orElseThrow(() -> new ResourceNotFoundException("detalleFactura", "id", iddetalle));
 repositorio.delete(dta);
    }

    @Override
    public List<Detalle_Factura> getAllServicios() {
        return repositorio.findByServicio();
    }

    @Override
    public List<Detalle_Factura> getAllProductos() {
        return repositorio.findByProducto();
    }
    
}
