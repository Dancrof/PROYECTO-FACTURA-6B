/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.servicios;

import com.sextob.progrmacion.entidades.Usuario;
import com.sextob.progrmacion.exepciones.NotFoundExeption;
import com.sextob.progrmacion.exepciones.ResourceRedundantExeption;
import com.sextob.progrmacion.repositorios.IUsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bryan
 */
@Component
public class UsuarioServiceImple implements IUsuarioService, UserDetailsService {

    @Autowired
    private IUsuarioRepository userRepo;

    @Override
    public Usuario createUser(Usuario usuario) {
        Optional<Usuario> user = this.userRepo.findByUsername(usuario.getUsername());
        if (!user.isPresent()) {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            return this.userRepo.save(usuario);
        }
        throw new ResourceRedundantExeption("Este usuario ya existe");
    }

    @Override
    public Usuario getUser(int id) {
        return this.userRepo.findById(id).orElseThrow(() -> new NotFoundExeption("Este usuario no existe"));
    }

    @Override
    public List<Usuario> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public boolean updateUser(int id, Usuario usuario) {
        Optional<Usuario> user = this.userRepo.findById(id);
        if (user.isPresent()) {

            user.get().setUsername(usuario.getUsername());
            user.get().setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));

            this.userRepo.save(user.get());
            return true;
        }
        throw new NotFoundExeption("Este usuario no existe");
    }

    @Override
    public boolean deleteUser(int id) {
        Optional<Usuario> user = this.userRepo.findById(id);
        if (user.isPresent()) {

            this.userRepo.delete(user.get());
            return true;
        }
        throw new NotFoundExeption("Este usuario no existe");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = this.userRepo.
                findByUsername(username)
                .orElseThrow(() -> new NotFoundExeption("Este usuario " + username + " no existe"));

        return new UserDetailsImpl(user);
    }

}
