/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.repositorios;

import com.sextob.progrmacion.entidades.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bryan
 */
@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer> {

    @Query(value = "select f.id, c.nombre, total from facturas f where c.nombre like %?1% JOIN clientes c ON f.cliente_id = c.id", nativeQuery = true)
    List<Factura> findByClienteContaining(String nameClient);
}
