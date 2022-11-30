
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Usuario;
import java.util.List;


public interface UsuarioService {
    
    public Usuario createUsuario(Usuario usuario);

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioById(long usu_id);

    public Usuario getUsuarioByUsuusuario(String usuusuario);

    public Usuario updateUsuario(long usu_id, Usuario usuario);

    public void deleteUsuario(long usu_id);
    
    Usuario getfindByUser(String usuusuario, String usu_contrasena);
}
