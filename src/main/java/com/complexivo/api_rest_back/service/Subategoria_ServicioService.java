/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;


import com.complexivo.api_rest_back.modelo.Subcategoria_Servicio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Subategoria_ServicioService {
    public Subcategoria_Servicio createSubcategoria(Subcategoria_Servicio subcategoria_Servicio);

    public List<Subcategoria_Servicio> getAllSubcategoria();

    public Subcategoria_Servicio getSubcategoriadById(long idsubcatser);

    public Subcategoria_Servicio getSubcategoriaByNombre(String subcatnombre);

    public Subcategoria_Servicio updateSubcategoria(long idsubcatser, Subcategoria_Servicio subcategoria_Servicio);

    public void deleteSubcategoria(long idsubcatser);
    
    public List<Subcategoria_Servicio> getAllCategorias(long id);
}
