package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Rol;
import com.complexivo.api_rest_back.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repository;


    @Override
    @Transactional
    public Rol createRol(Rol rol) {
        return repository.save(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> getAllRol() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Rol getRolById(long idrol) {
        return repository.findById(idrol)
                .orElseThrow(() ->
                new ResourceNotFoundException("Rol","id",idrol));
    }

    @Override
    @Transactional(readOnly = true)
    public Rol getRolfindByRolnomobre(String rolnombre) {

        Rol roll =repository.findByRolnombre(rolnombre).
                orElseThrow(() ->
                        new ResourceNotFoundException("Rol","rol",rolnombre));

         return roll;
    }

    @Override
    @Transactional
    public Rol updateRol(long idrol, Rol rol) {
        Rol r = repository.findById(idrol)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rol","id", idrol));

        r.setRolnombre(rol.getRolnombre());
        r.setDescripcion(rol.getDescripcion());
        return repository.save(r);
    }

    @Override
    @Transactional
    public void deleteById(long idrol) {
        Rol  r = repository.findById(idrol)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rol", "id", idrol));

        repository.delete(r);


    }
}
