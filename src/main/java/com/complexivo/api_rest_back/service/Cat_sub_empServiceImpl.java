/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.AppException;
import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Cat_sub_emp;
import com.complexivo.api_rest_back.repository.Cat_sub_empRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class Cat_sub_empServiceImpl implements Cat_sub_empService {

    @Autowired
    private Cat_sub_empRepository repository;
    
    @Override
    @Transactional
    public Cat_sub_emp createDetalle(Cat_sub_emp cat_sub_emp) {
        if (repository.existsByCsedetalle(cat_sub_emp.getCsedetalle())) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El detalle ingresado ya se encuentra en otro registro");
        }

        return repository.save(cat_sub_emp);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cat_sub_emp> getAllDetalle() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cat_sub_emp getDetalleById(long iddetalle) {
        return repository.findById(iddetalle)
                .orElseThrow(() -> new ResourceNotFoundException("cat_sub_emp", "id", iddetalle));

    }

    @Override
    @Transactional(readOnly = true)
    public Cat_sub_emp getDetalleByDet(String csedetalle) {
        Cat_sub_emp cse = repository.findByCsedetalle(csedetalle)
                .orElseThrow(() -> new ResourceNotFoundException("cat_sub_emp", "empruc", csedetalle));

        return cse;
    }

    @Override
    @Transactional
    public Cat_sub_emp updateDetalle(long iddetalle, Cat_sub_emp cat_sub_emp) {
         Cat_sub_emp e = repository.findById(iddetalle)
                .orElseThrow(() -> new ResourceNotFoundException("cat_sub_emp", "id", iddetalle));

         
        e.setIdcatemp(cat_sub_emp.getIdcatemp()); 
        e.setIddetalle(cat_sub_emp.getIddetalle());
        e.setIdempresa(cat_sub_emp.getIdempresa());
        e.setCsedetalle(cat_sub_emp.getCsedetalle());
        e.setIdsubcatemp(cat_sub_emp.getIdsubcatemp());
   
        return repository.save(e);
    }

    @Override
    @Transactional
    public void deleteDetalle(long iddetalle) {
          Cat_sub_emp cse = repository.findById(iddetalle)
                .orElseThrow(() -> new ResourceNotFoundException("cat_sub_emp", "id", iddetalle));

        repository.delete(cse);
    }
    
    @Override
    public List<Cat_sub_emp> getIdempresa(long id) {
        return repository.findByIdempresa(id);
    }
}
