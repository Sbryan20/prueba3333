
package com.complexivo.api_rest_back.controller;

import com.complexivo.api_rest_back.modelo.Empresa;
import com.complexivo.api_rest_back.modelo.Usuario;
import com.complexivo.api_rest_back.service.EmpresaService;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.complexivo.api_rest_back.service.UsuarioService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private EmpresaService empresaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listUsuario() {
		return new ResponseEntity<>(usuarioService.getAllUsuario(), HttpStatus.OK);
	}

	@GetMapping("/listar/{usuusuario}")
	public ResponseEntity<Usuario> getPersonaByDNI(@PathVariable String usuusuario){
		return new ResponseEntity<>(usuarioService.getUsuarioByUsuusuario(usuusuario), HttpStatus.OK);
	}
        
	@GetMapping("/listar id/{usu_id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usu_id){
		return new ResponseEntity<>(usuarioService.getUsuarioById(usu_id), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody Usuario usuario) {

		return new ResponseEntity<>(usuarioService.createUsuario(usuario), HttpStatus.CREATED);

	}
	
	@PutMapping("editar/{usu_id}")
	public ResponseEntity<Usuario> updateUsuario(@Valid @PathVariable long usu_id,@Valid  @RequestBody Usuario usaurio) {

		Usuario updatedUsuario = usuarioService.updateUsuario(usu_id, usaurio);
		return new ResponseEntity<>(updatedUsuario, HttpStatus.CREATED);
	}
	
	@DeleteMapping("eliminar/{usu_id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable long usu_id) {
		usuarioService.deleteUsuario(usu_id);
		return new ResponseEntity<>(HttpStatus.OK);
    }

	@PostMapping("/login")
	public Integer login(@RequestBody Usuario userRequest) {
		Usuario usuario = usuarioService.getfindByUser(userRequest.getUsuusuario(), userRequest.getUsu_contrasena());
		if (usuario == null) {
			return 0;
		} else {
			return 1;
		}
	}
        
        @PostMapping("/loginweb")
	public Usuario loginweb(@RequestBody Usuario userRequest) {
		Usuario usuario = usuarioService.getfindByUser(userRequest.getUsuusuario(), userRequest.getUsu_contrasena());
		if (usuario == null) {
			return null;
		} else {
			return usuario;
		}
	}


	
        
        @PostMapping("/consulta_empresa")
	public Empresa consulta_empresa(@RequestBody Usuario id) {
               
		Empresa empresa = empresaService.getfindByUser(id.getUsu_id());
               
		if (empresa == null) {
			return null;
		} else {
                        
                    
			return empresa;
		}
	}
        
        
	}

