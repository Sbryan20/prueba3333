/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Empresa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EmpresaService {
    public Empresa createEmpresa(Empresa empresa);

    public List<Empresa> getAllEmpresa();

    public Empresa getEmpresaById(long idempresa);

    public Empresa getEmpresaByEmpnombre(String empnombre);

    public Empresa updateEmpresa(long idempresa, Empresa empresa);

    public void deleteEmpresa(long idempresa);
    
    public List<Empresa> getAllReporte(long id);
    
    Empresa getfindByUser(long usu_id);
    
    public List<Object> getRanking();
}
