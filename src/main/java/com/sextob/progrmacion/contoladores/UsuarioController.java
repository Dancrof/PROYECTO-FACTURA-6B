/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.contoladores;

import com.sextob.progrmacion.entidades.Usuario;
import com.sextob.progrmacion.servicios.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bryan
 */
@RestController
@RequestMapping("/api/users")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService userSvc;
    
    @PostMapping
    private ResponseEntity<Usuario> endPointCreateUser(@RequestBody Usuario usuario){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userSvc.createUser(usuario));
    }
    
    @GetMapping
    private ResponseEntity<List<Usuario>> endPointGetAllUser(){
        
        return ResponseEntity.status(200).body(this.userSvc.getAllUser());
    }
    
    @GetMapping("/{id}")
    private ResponseEntity<Usuario> endPointGetUser(@PathVariable int id){
    
        return ResponseEntity.status(200).body(this.userSvc.getUser(id));       
    }
    
    @PutMapping("/{id}")
    private ResponseEntity<Boolean> endPointUpdateUser(@PathVariable int id, @RequestBody Usuario usuario){
    
        return ResponseEntity.status(201).body(this.userSvc.updateUser(id, usuario));       
    }
    
    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> endPointDeleteUser(@PathVariable int id){
    
        return ResponseEntity.status(201).body(this.userSvc.deleteUser(id));       
    }
     
}
