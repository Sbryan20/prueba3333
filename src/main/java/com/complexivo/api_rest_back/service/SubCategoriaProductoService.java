
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.SubCategoriaProducto;
import java.util.List;


public interface SubCategoriaProductoService {
    
    public SubCategoriaProducto createSubCategoriaProducto(SubCategoriaProducto subcategoriaproducto);

    public List<SubCategoriaProducto> getAllSubCategoriaProducto();

    public SubCategoriaProducto getSubCategoriaProductoById(long subcatproid);

    public SubCategoriaProducto getSubCategoriaProductoByCatpronombre(String subcatpronombre);

    public SubCategoriaProducto updateSubCategoriaProducto(long subcatproid, SubCategoriaProducto subcategoriaproducto);

    public void deleteSubCategoriaProducto(long subcatproid);
    
    public List<SubCategoriaProducto> getAllCategorias(long id);
}
