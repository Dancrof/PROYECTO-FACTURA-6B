/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.servicios;

import com.sextob.progrmacion.entidades.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public interface IClienteService {
    
    Cliente createClient(Cliente cliente);
    
    Cliente getClient(int id);
    
    List<Cliente> getAllClient();
    
    boolean updateClient(int id, Cliente cliente);
    
    boolean deleteClient(int id);
}
