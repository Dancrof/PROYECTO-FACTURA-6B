/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.servicios;

import com.sextob.progrmacion.entidades.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bryan
 */
@Service
public interface IUsuarioService {
    
    Usuario createUser(Usuario usuario);
    
    Usuario getUser(int id);   
    
    List<Usuario> getAllUser();
    
    boolean updateUser(int id, Usuario usuario);
    
    boolean deleteUser(int id);
}
