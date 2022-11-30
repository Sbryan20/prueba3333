/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.AppException;
import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Solicitud;
import com.complexivo.api_rest_back.repository.SolicitudRepository;
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
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;
    
    @Override
    @Transactional
    public Solicitud createSolicitud(Solicitud solicitud) {
//        if (solicitudRepository.existsByNombre(solicitud.getNombre())) {
//            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,
//                    "El nombre se solicitud ingresada ya se encuentra en otro registro");
//        }

        return solicitudRepository.save(solicitud);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> getAllSolicitud() {
        return solicitudRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Solicitud getSolicitudById(long idsolicitud) {
        return solicitudRepository.findById(idsolicitud)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud", "id", idsolicitud));

    }

    

    @Override
    @Transactional
    public Solicitud updateSolicitud(long idsolicitud, Solicitud solicitud) {
        Solicitud s = solicitudRepository.findById(idsolicitud)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud", "id", idsolicitud));

        
        s.setSol_fecharegistro(solicitud.getSol_fecharegistro());
        s.setSol_estado(solicitud.getSol_estado());
        s.setSol_detalleestado(solicitud.getSol_detalleestado());
        
        

        return solicitudRepository.save(s);
    }

    @Override
    @Transactional
    public void deleteSolicitud(long idsolicitud) {
        Solicitud solicitud = solicitudRepository.findById(idsolicitud)
                .orElseThrow(() -> new ResourceNotFoundException("Solicitud", "id", idsolicitud));

        solicitudRepository.delete(solicitud);
    }

    
    
}
