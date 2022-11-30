/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;


import com.complexivo.api_rest_back.modelo.Categoria_Servicio;
import com.complexivo.api_rest_back.modelo.Servicio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Categoria_ServicioService {
    public Categoria_Servicio createCategoria(Categoria_Servicio categoria_Servicio);

    public List<Categoria_Servicio> getAllCategoria();

    public Categoria_Servicio getCategoriadById(long idcatser);

    public Categoria_Servicio getCategoriaByNombre(String catnombre);

    public Categoria_Servicio updateCategoria(long idcatser, Categoria_Servicio categoria_Servicio);

    public void deleteCategoria(long idcatser);
    
    //Categoria_Servicio getfindByIdcatser(Long idcatser);
}
