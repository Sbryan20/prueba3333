/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Solicitud;
import com.complexivo.api_rest_back.service.SolicitudService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/listar")
    public ResponseEntity<List<Solicitud>> listSolicitudes() {

        return new ResponseEntity<>(solicitudService.getAllSolicitud(), HttpStatus.OK);
    }

   @GetMapping("/listar id/{idsolicitud}")
    public ResponseEntity<Solicitud> getSolicitudById(@PathVariable Long idsolicitud) {

        return new ResponseEntity<>(solicitudService.getSolicitudById(idsolicitud), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Solicitud> saveSolicitud(@Valid @RequestBody Solicitud solicitud) {

        return new ResponseEntity<>(solicitudService.createSolicitud(solicitud), HttpStatus.CREATED);

    }

    @PutMapping("/editar/{idsolicitud}")
    public ResponseEntity<Solicitud> editSolicitud(@Valid @PathVariable long idsolicitud, @Valid @RequestBody Solicitud solicitud) {

        Solicitud updatedSoli = solicitudService.updateSolicitud(idsolicitud, solicitud);
        return new ResponseEntity<>(updatedSoli, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{idsolicitud}")
    public ResponseEntity<Solicitud> deleteSolicitud(@PathVariable long idsolicitud) {

        solicitudService.deleteSolicitud(idsolicitud);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
