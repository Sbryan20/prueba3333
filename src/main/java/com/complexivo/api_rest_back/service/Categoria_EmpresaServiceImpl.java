/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.AppException;
import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Categoria_Empresa;
import com.complexivo.api_rest_back.repository.Categoria_EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class Categoria_EmpresaServiceImpl implements Categoria_EmpresaService{

    @Autowired
    private Categoria_EmpresaRepository repository;
    
    @Override
    public Categoria_Empresa createCategoria(Categoria_Empresa categoria_Empresa) {
        if (repository.existsByCatnombre(categoria_Empresa.getCatnombre())) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El nombre se categoria ingresada ya se encuentra en otro registro");
        }

        return repository.save(categoria_Empresa);
    }

    @Override
    public List<Categoria_Empresa> getAllCategoria() {
         return repository.findAll();
    }

    @Override
    public Categoria_Empresa getCategoriadById(long idcatemp) {
        return repository.findById(idcatemp)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria_Empresa", "id", idcatemp));

    }

    @Override
    public Categoria_Empresa getCategoriaByNombre(String catnombre) {
        Categoria_Empresa cat= repository.findByCatnombre(catnombre)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria_Empresa", "catnombre", catnombre));

        return cat; 
    }

    @Override
    public Categoria_Empresa updateCategoria(long idcatemp, Categoria_Empresa categoria_Empresa) {
        Categoria_Empresa c = repository.findById(idcatemp)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria_Empresa", "id", idcatemp));

        c.setCatnombre(categoria_Empresa.getCatnombre());
        c.setCatdescripcion(categoria_Empresa.getCatdescripcion());

        return repository.save(c);
    }

    @Override
    public void deleteCategoria(long idcatemp) {
         Categoria_Empresa cat = repository.findById(idcatemp)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria_Empresa", "id", idcatemp));

        repository.delete(cat);
    }
    
}
