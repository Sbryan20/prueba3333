
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.CategoriaProducto;
import java.util.List;


public interface CategoriaProductoService {
    
    public CategoriaProducto createCategoriaProducto(CategoriaProducto categoriaproducto);

    public List<CategoriaProducto> getAllCategoriaProducto();

    public CategoriaProducto getCategoriaProductoById(long catproid);

    public CategoriaProducto getCategoriaProductoByCatpronombre(String catpronombre);

    public CategoriaProducto updateCategoriaProducto(long catproid, CategoriaProducto categoriaproducto);

    public void deleteCategoriaProducto(long catproid);
}
