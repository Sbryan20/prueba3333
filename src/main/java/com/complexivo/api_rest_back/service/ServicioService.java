/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Servicio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ServicioService {
    public Servicio createServicio(Servicio servicio);

    public List<Servicio> getAllServicio();

    public Servicio getServicioById(long idservicio);

    public Servicio getServicioBySernombre(String sernombre);

    public Servicio updateServicio(long idservicio, Servicio servicio);

    public void deleteServicio(long idservicio);
    
    public List<Servicio> getAllCategorias(long id);
    
    public List<Servicio> getAllSubcategorias(long id);
    
    public List<Servicio> getIdempresa(long id);
}
