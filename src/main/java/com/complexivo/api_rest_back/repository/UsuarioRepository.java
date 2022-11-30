
package com.complexivo.api_rest_back.repository;


import com.complexivo.api_rest_back.modelo.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByUsuusuario(String usuusuario);
	
    public Boolean existsByUsuusuario(String usuusuario);
    
    @Query(value = "Select * from usuario u where u.usuusuario = :usuusuario and u.usu_contrasena=:usu_contrasena",nativeQuery=true)
    public Usuario findByUser(String usuusuario, String usu_contrasena);
}
