package com.complexivo.api_rest_back.controller;


import com.complexivo.api_rest_back.modelo.Rol;
import com.complexivo.api_rest_back.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listRol(){
        return  new ResponseEntity<>(
                service.getAllRol(),
                HttpStatus.OK
        );
    }

    @GetMapping("/listar/{rolnombre}")
    public ResponseEntity<Rol> getRolNombre(@PathVariable String rolnombre){
        return  new ResponseEntity<>(
                service.getRolfindByRolnomobre(rolnombre),
                HttpStatus.OK
        );
    }
    
    @GetMapping("/listar id/{idrol}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long idrol){
        return  new ResponseEntity<>(
                service.getRolById(idrol),
                HttpStatus.OK
        );
    }


    @PostMapping("crear")
    public ResponseEntity<Rol> saveRol (@Valid @RequestBody Rol rol){
        return new ResponseEntity<>(
                service.createRol(rol),
                HttpStatus.OK
        );
    }

    @PutMapping("editar/{idrol}")
    public ResponseEntity<Rol> updateRol(@Valid @PathVariable long idrol, @Valid @RequestBody Rol rol){
        Rol r= service.updateRol(idrol, rol);
        return new ResponseEntity<>(r,
                HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{idrol}")
    public ResponseEntity<Rol> deleteRol(@PathVariable long idrol){
        service.deleteById(idrol);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
