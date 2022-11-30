
package com.complexivo.api_rest_back.service;

import com.complexivo.api_rest_back.modelo.Producto;
import java.util.List;


public interface ProductoService {
    
    public Producto createProducto(Producto producto);

    public List<Producto> getAllProducto();

    public Producto getProductoById(long idproducto);

    public Producto getProductoByProducto(String nombre);

    public Producto updateProducto(long idproducto, Producto producto);

    public void deleteProducto(long idproducto);
    
     public List<Producto> getAllCategorias(long id);
    
    public List<Producto> getAllSubcategorias(long id);
    
    public List<List> getProductos(Long idempresa);
    
    public List<Producto> getIdempresa(long id);
}
