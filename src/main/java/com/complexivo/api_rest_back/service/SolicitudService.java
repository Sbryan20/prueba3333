/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Solicitud;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface SolicitudService {
    
    public Solicitud createSolicitud(Solicitud solicitud);

    public List<Solicitud> getAllSolicitud();

    public Solicitud getSolicitudById(long idsolicitud);

    

    public Solicitud updateSolicitud(long idsolicitud, Solicitud solicitud);

    public void deleteSolicitud(long idsolicitud);
}
