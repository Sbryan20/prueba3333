
package com.complexivo.api_rest_back.repository;


import com.complexivo.api_rest_back.modelo.CategoriaProducto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Long> {
    
    public Optional<CategoriaProducto> findByCatpronombre(String catpronombre);
	
    public Boolean existsByCatpronombre(String catpronombre);
}
