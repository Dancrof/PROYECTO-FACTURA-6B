/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.repositorios;

import com.sextob.progrmacion.entidades.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bryan
 */
@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
    
    Optional<Cliente> findByNombre(String cliente);
}
