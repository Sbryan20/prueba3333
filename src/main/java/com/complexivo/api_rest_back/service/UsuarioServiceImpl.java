
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.exeption.AppException;
import com.complexivo.api_rest_back.exeption.ResourceNotFoundException;
import com.complexivo.api_rest_back.modelo.Usuario;
import com.complexivo.api_rest_back.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        if (usuarioRepository.existsByUsuusuario(usuario.getUsuusuario())) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "El usuario ingresado ya esta en uso");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioById(long usu_id) {
        return usuarioRepository.findById(usu_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usu_id));

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsuusuario(String usuusuario) {
        Usuario usuario = usuarioRepository.findByUsuusuario(usuusuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "usuario", usuusuario));

        return usuario;
    }

    @Override
    @Transactional()
    public Usuario updateUsuario(long usu_id, Usuario usuario) {
        Usuario u = usuarioRepository.findById(usu_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usu_id));

        u.setRol_id(usuario.getRol_id());
        u.setPersona(usuario.getPersona());
        u.setUsuusuario(usuario.getUsuusuario());
        u.setUsu_contrasena(usuario.getUsu_contrasena());

        return usuarioRepository.save(u);
    }

    @Override
    @Transactional
    public void deleteUsuario(long usu_id) {
        Usuario usuario = usuarioRepository.findById(usu_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", usu_id));

        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario getfindByUser(String usuusuario, String usu_contrasena) {
        return usuarioRepository.findByUser(usuusuario,usu_contrasena);
    }
}
