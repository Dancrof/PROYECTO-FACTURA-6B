/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.servicios;

import com.sextob.progrmacion.entidades.Producto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public interface IProductoService {
    
    Producto createProduct(Producto producto);
    
    Producto getProduct(int id);
    
    List<Producto> getAllProduct(String filter);
    
    boolean updateProduct(int id, Producto producto);
    
    boolean deleteProduct(int id);
}
