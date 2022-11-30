/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;


import com.complexivo.api_rest_back.modelo.Categoria_Empresa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Categoria_EmpresaService {
    public Categoria_Empresa createCategoria(Categoria_Empresa categoria_Empresa);

    public List<Categoria_Empresa> getAllCategoria();

    public Categoria_Empresa getCategoriadById(long idcatemp);

    public Categoria_Empresa getCategoriaByNombre(String catnombre);

    public Categoria_Empresa updateCategoria(long idcatemp, Categoria_Empresa categoria_Empresa);

    public void deleteCategoria(long idcatemp);
}
