/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Cat_sub_emp;
import java.util.List;



/**
 *
 * @author Usuario
 */
public interface Cat_sub_empService {
    public Cat_sub_emp createDetalle(Cat_sub_emp cat_sub_emp);

    public List<Cat_sub_emp> getAllDetalle();

    public Cat_sub_emp getDetalleById(long iddetalle);

    public Cat_sub_emp getDetalleByDet(String csedetalle);

    public Cat_sub_emp updateDetalle(long iddetalle, Cat_sub_emp cat_sub_emp);

    public void deleteDetalle(long iddetalle);
    
    public List<Cat_sub_emp> getIdempresa(long id);
}
