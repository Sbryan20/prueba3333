/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;


import com.complexivo.api_rest_back.modelo.Subcategoria_Empresa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Subategoria_EmpresaService {
    public Subcategoria_Empresa createSubcategoria(Subcategoria_Empresa subcategoria_Empresa);

    public List<Subcategoria_Empresa> getAllSubcategoria();

    public Subcategoria_Empresa getSubcategoriadById(long idsubcatemp);

    public Subcategoria_Empresa getSubcategoriaByNombre(String subcatnombre);

    public Subcategoria_Empresa updateSubcategoria(long idsubcatemp, Subcategoria_Empresa subcategoria_Empresa);

    public void deleteSubcategoria(long idsubcatemp);
    
    public List<Subcategoria_Empresa> getAllCategorias(long id);
}
