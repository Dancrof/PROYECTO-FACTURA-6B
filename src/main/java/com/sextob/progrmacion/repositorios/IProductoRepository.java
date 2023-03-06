/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.repositorios;

import com.sextob.progrmacion.entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bryan
 */
@Repository
public interface IProductoRepository  extends  JpaRepository<Producto, Integer>{
    
    @Query(value = "select * from productos p where p.item like %?1%", nativeQuery = true)
    List<Producto> findByItemContaining(String item);
}
